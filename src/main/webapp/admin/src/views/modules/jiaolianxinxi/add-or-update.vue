<template>
	<div class="addEdit-block" :style='{"minHeight":"100vh","padding":"30px","background":"url(http://codegen.caihongy.cn/20230401/bd196cf1072f48afae5676066a72e297.jpg) fixed no-repeat center top / 100% 100%"}' style="width: 100%;">
		<el-form
			:style='{"padding":"20px","boxShadow":"0 0px 0px #ddd","borderRadius":"0px","background":"none"}'
			class="add-update-preview"
			ref="ruleForm"
			:model="ruleForm"
			:rules="rules"
			label-width="180px"
		>
			<template >
				<el-form-item :style='{"margin":"0 0 20px 0"}' class="input" v-if="type!='info'" label="教练编号" prop="jiaolianbianhao">
					<el-input v-model="ruleForm.jiaolianbianhao" placeholder="教练编号" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' class="input" v-else-if="ruleForm.jiaolianbianhao" label="教练编号" prop="jiaolianbianhao">
					<el-input v-model="ruleForm.jiaolianbianhao" placeholder="教练编号" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' class="input" v-if="type!='info'"  label="教练名称" prop="jiaolianmingcheng">
					<el-input v-model="ruleForm.jiaolianmingcheng" placeholder="教练名称" clearable  :readonly="ro.jiaolianmingcheng"></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' v-else class="input" label="教练名称" prop="jiaolianmingcheng">
					<el-input v-model="ruleForm.jiaolianmingcheng" placeholder="教练名称" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' class="upload" v-if="type!='info' && !ro.jiaolianzhaopian" label="教练照片" prop="jiaolianzhaopian">
					<file-upload
						tip="点击上传教练照片"
						action="file/upload"
						:limit="3"
						:multiple="true"
						:fileUrls="ruleForm.jiaolianzhaopian?ruleForm.jiaolianzhaopian:''"
						@change="jiaolianzhaopianUploadChange"
					></file-upload>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' class="upload" v-else-if="ruleForm.jiaolianzhaopian" label="教练照片" prop="jiaolianzhaopian">
					<img v-if="ruleForm.jiaolianzhaopian.substring(0,4)=='http'" class="upload-img" style="margin-right:20px;" v-bind:key="index" :src="ruleForm.jiaolianzhaopian.split(',')[0]" width="100" height="100">
					<img v-else class="upload-img" style="margin-right:20px;" v-bind:key="index" v-for="(item,index) in ruleForm.jiaolianzhaopian.split(',')" :src="$base.url+item" width="100" height="100">
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' class="select" v-if="type!='info'"  label="教练性别" prop="jiaolianxingbie">
					<el-select :disabled="ro.jiaolianxingbie" v-model="ruleForm.jiaolianxingbie" placeholder="请选择教练性别" >
						<el-option
							v-for="(item,index) in jiaolianxingbieOptions"
							v-bind:key="index"
							:label="item"
							:value="item">
						</el-option>
					</el-select>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' v-else class="input" label="教练性别" prop="jiaolianxingbie">
					<el-input v-model="ruleForm.jiaolianxingbie"
						placeholder="教练性别" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' class="input" v-if="type!='info'"  label="教练特长" prop="jiaoliantezhang">
					<el-input v-model="ruleForm.jiaoliantezhang" placeholder="教练特长" clearable  :readonly="ro.jiaoliantezhang"></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' v-else class="input" label="教练特长" prop="jiaoliantezhang">
					<el-input v-model="ruleForm.jiaoliantezhang" placeholder="教练特长" readonly></el-input>
				</el-form-item>
			</template>
				<el-form-item :style='{"margin":"0 0 20px 0"}' class="textarea" v-if="type!='info'" label="教练简介" prop="jiaolianjianjie">
					<el-input
					  style="min-width: 200px; max-width: 600px;"
					  type="textarea"
					  :rows="8"
					  placeholder="教练简介"
					  v-model="ruleForm.jiaolianjianjie" >
					</el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' v-else-if="ruleForm.jiaolianjianjie" label="教练简介" prop="jiaolianjianjie">
					<span :style='{"fontSize":"16px","lineHeight":"40px","color":"#666","fontWeight":"500","display":"inline-block"}'>{{ruleForm.jiaolianjianjie}}</span>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' v-if="type!='info'"  label="教练详情" prop="jiaolianxiangqing">
					<editor 
						style="min-width: 200px; max-width: 600px;"
						v-model="ruleForm.jiaolianxiangqing" 
						class="editor" 
						action="file/upload">
					</editor>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' v-else-if="ruleForm.jiaolianxiangqing" label="教练详情" prop="jiaolianxiangqing">
                    <span :style='{"fontSize":"16px","lineHeight":"40px","color":"#666","fontWeight":"500","display":"inline-block"}' v-html="ruleForm.jiaolianxiangqing"></span>
                </el-form-item>
			<el-form-item :style='{"padding":"0","margin":"0"}' class="btn">
				<el-button :style='{"border":"0","cursor":"pointer","padding":"0","margin":"0 20px 0 0","outline":"none","color":"#fff","borderRadius":"4px","background":"#9fc4ee","width":"128px","lineHeight":"40px","fontSize":"16px","height":"40px"}'  v-if="type!='info'" type="primary" class="btn-success" @click="onSubmit">提交</el-button>
				<el-button :style='{"border":"0px solid #1b5a90","cursor":"pointer","padding":"0","margin":"0","outline":"none","color":"#fff","borderRadius":"4px","background":"#ccc","width":"128px","lineHeight":"40px","fontSize":"16px","height":"40px"}' v-if="type!='info'" class="btn-close" @click="back()">取消</el-button>
				<el-button :style='{"border":"0px solid #1b5a90","cursor":"pointer","padding":"0","margin":"0","outline":"none","color":"#fff","borderRadius":"4px","background":"#ccc","width":"128px","lineHeight":"40px","fontSize":"16px","height":"40px"}' v-if="type=='info'" class="btn-close" @click="back()">返回</el-button>
			</el-form-item>
		</el-form>
    

  </div>
</template>
<script>
// 数字，邮件，手机，url，身份证校验
import { isNumber,isIntNumer,isEmail,isPhone, isMobile,isURL,checkIdCard } from "@/utils/validate";
export default {
	data() {
		let self = this
		var validateIdCard = (rule, value, callback) => {
			if(!value){
				callback();
			} else if (!checkIdCard(value)) {
				callback(new Error("请输入正确的身份证号码"));
			} else {
				callback();
			}
		};
		var validateUrl = (rule, value, callback) => {
			if(!value){
				callback();
			} else if (!isURL(value)) {
				callback(new Error("请输入正确的URL地址"));
			} else {
				callback();
			}
		};
		var validateMobile = (rule, value, callback) => {
			if(!value){
				callback();
			} else if (!isMobile(value)) {
				callback(new Error("请输入正确的手机号码"));
			} else {
				callback();
			}
		};
		var validatePhone = (rule, value, callback) => {
			if(!value){
				callback();
			} else if (!isPhone(value)) {
				callback(new Error("请输入正确的电话号码"));
			} else {
				callback();
			}
		};
		var validateEmail = (rule, value, callback) => {
			if(!value){
				callback();
			} else if (!isEmail(value)) {
				callback(new Error("请输入正确的邮箱地址"));
			} else {
				callback();
			}
		};
		var validateNumber = (rule, value, callback) => {
			if(!value){
				callback();
			} else if (!isNumber(value)) {
				callback(new Error("请输入数字"));
			} else {
				callback();
			}
		};
		var validateIntNumber = (rule, value, callback) => {
			if(!value){
				callback();
			} else if (!isIntNumer(value)) {
				callback(new Error("请输入整数"));
			} else {
				callback();
			}
		};
		return {
			id: '',
			type: '',
			
			
			ro:{
				jiaolianbianhao : false,
				jiaolianmingcheng : false,
				jiaolianzhaopian : false,
				jiaolianxingbie : false,
				jiaoliantezhang : false,
				jiaolianjianjie : false,
				jiaolianxiangqing : false,
			},
			
			
			ruleForm: {
				jiaolianbianhao: this.getUUID(),
				jiaolianmingcheng: '',
				jiaolianzhaopian: '',
				jiaolianxingbie: '',
				jiaoliantezhang: '',
				jiaolianjianjie: '',
				jiaolianxiangqing: '',
			},
		
			jiaolianxingbieOptions: [],

			
			rules: {
				jiaolianbianhao: [
				],
				jiaolianmingcheng: [
				],
				jiaolianzhaopian: [
				],
				jiaolianxingbie: [
				],
				jiaoliantezhang: [
				],
				jiaolianjianjie: [
				],
				jiaolianxiangqing: [
				],
			}
		};
	},
	props: ["parent"],
	computed: {



	},
    components: {
    },
	created() {
	},
	methods: {
		
		// 下载
		download(file){
			window.open(`${file}`)
		},
		// 初始化
		init(id,type) {
			if (id) {
				this.id = id;
				this.type = type;
			}
			if(this.type=='info'||this.type=='else'){
				this.info(id);
			}else if(this.type=='logistics'){
				this.logistics=false;
				this.info(id);
			}else if(this.type=='cross'){
				var obj = this.$storage.getObj('crossObj');
				for (var o in obj){
						if(o=='jiaolianbianhao'){
							this.ruleForm.jiaolianbianhao = obj[o];
							this.ro.jiaolianbianhao = true;
							continue;
						}
						if(o=='jiaolianmingcheng'){
							this.ruleForm.jiaolianmingcheng = obj[o];
							this.ro.jiaolianmingcheng = true;
							continue;
						}
						if(o=='jiaolianzhaopian'){
							this.ruleForm.jiaolianzhaopian = obj[o];
							this.ro.jiaolianzhaopian = true;
							continue;
						}
						if(o=='jiaolianxingbie'){
							this.ruleForm.jiaolianxingbie = obj[o];
							this.ro.jiaolianxingbie = true;
							continue;
						}
						if(o=='jiaoliantezhang'){
							this.ruleForm.jiaoliantezhang = obj[o];
							this.ro.jiaoliantezhang = true;
							continue;
						}
						if(o=='jiaolianjianjie'){
							this.ruleForm.jiaolianjianjie = obj[o];
							this.ro.jiaolianjianjie = true;
							continue;
						}
						if(o=='jiaolianxiangqing'){
							this.ruleForm.jiaolianxiangqing = obj[o];
							this.ro.jiaolianxiangqing = true;
							continue;
						}
				}
				







			}
			
			
			// 获取用户信息
			this.$http({
				url: `${this.$storage.get('sessionTable')}/session`,
				method: "get"
			}).then(({ data }) => {
				if (data && data.code === 0) {
					
					var json = data.data;
				} else {
					this.$message.error(data.msg);
				}
			});
			
            this.jiaolianxingbieOptions = "男,女".split(',')
			
		},
    // 多级联动参数

    info(id) {
      this.$http({
        url: `jiaolianxinxi/info/${id}`,
        method: "get"
      }).then(({ data }) => {
        if (data && data.code === 0) {
        this.ruleForm = data.data;
        //解决前台上传图片后台不显示的问题
        let reg=new RegExp('../../../upload','g')//g代表全部
        this.ruleForm.jiaolianxiangqing = this.ruleForm.jiaolianxiangqing.replace(reg,'../../../ssmbgnk6/upload');
        } else {
          this.$message.error(data.msg);
        }
      });
    },


    // 提交
    onSubmit() {






	if(this.ruleForm.jiaolianzhaopian!=null) {
		this.ruleForm.jiaolianzhaopian = this.ruleForm.jiaolianzhaopian.replace(new RegExp(this.$base.url,"g"),"");
	}









var objcross = this.$storage.getObj('crossObj');

      //更新跨表属性
       var crossuserid;
       var crossrefid;
       var crossoptnum;
       if(this.type=='cross'){
                var statusColumnName = this.$storage.get('statusColumnName');
                var statusColumnValue = this.$storage.get('statusColumnValue');
                if(statusColumnName!='') {
                        var obj = this.$storage.getObj('crossObj');
                       if(statusColumnName && !statusColumnName.startsWith("[")) {
                               for (var o in obj){
                                 if(o==statusColumnName){
                                   obj[o] = statusColumnValue;
                                 }
                               }
                               var table = this.$storage.get('crossTable');
                             this.$http({
                                 url: `${table}/update`,
                                 method: "post",
                                 data: obj
                               }).then(({ data }) => {});
                       } else {
                               crossuserid=this.$storage.get('userid');
                               crossrefid=obj['id'];
                               crossoptnum=this.$storage.get('statusColumnName');
                               crossoptnum=crossoptnum.replace(/\[/,"").replace(/\]/,"");
                        }
                }
        }
       this.$refs["ruleForm"].validate(valid => {
         if (valid) {
		 if(crossrefid && crossuserid) {
			 this.ruleForm.crossuserid = crossuserid;
			 this.ruleForm.crossrefid = crossrefid;
			let params = { 
				page: 1, 
				limit: 10, 
				crossuserid:this.ruleForm.crossuserid,
				crossrefid:this.ruleForm.crossrefid,
			} 
			this.$http({ 
				url: "jiaolianxinxi/page", 
				method: "get", 
				params: params 
			}).then(({ 
				data 
			}) => { 
				if (data && data.code === 0) { 
				       if(data.data.total>=crossoptnum) {
					     this.$message.error(this.$storage.get('tips'));
					       return false;
				       } else {
					 this.$http({
					   url: `jiaolianxinxi/${!this.ruleForm.id ? "save" : "update"}`,
					   method: "post",
					   data: this.ruleForm
					 }).then(({ data }) => {
					   if (data && data.code === 0) {
					     this.$message({
					       message: "操作成功",
					       type: "success",
					       duration: 1500,
					       onClose: () => {
						 this.parent.showFlag = true;
						 this.parent.addOrUpdateFlag = false;
						 this.parent.jiaolianxinxiCrossAddOrUpdateFlag = false;
						 this.parent.search();
						 this.parent.contentStyleChange();
					       }
					     });
					   } else {
					     this.$message.error(data.msg);
					   }
					 });

				       }
				} else { 
				} 
			});
		 } else {
			 this.$http({
			   url: `jiaolianxinxi/${!this.ruleForm.id ? "save" : "update"}`,
			   method: "post",
			   data: this.ruleForm
			 }).then(({ data }) => {
			   if (data && data.code === 0) {
			     this.$message({
			       message: "操作成功",
			       type: "success",
			       duration: 1500,
			       onClose: () => {
				 this.parent.showFlag = true;
				 this.parent.addOrUpdateFlag = false;
				 this.parent.jiaolianxinxiCrossAddOrUpdateFlag = false;
				 this.parent.search();
				 this.parent.contentStyleChange();
			       }
			     });
			   } else {
			     this.$message.error(data.msg);
			   }
			 });
		 }
         }
       });
    },
    // 获取uuid
    getUUID () {
      return new Date().getTime();
    },
    // 返回
    back() {
      this.parent.showFlag = true;
      this.parent.addOrUpdateFlag = false;
      this.parent.jiaolianxinxiCrossAddOrUpdateFlag = false;
      this.parent.contentStyleChange();
    },
    jiaolianzhaopianUploadChange(fileUrls) {
	    this.ruleForm.jiaolianzhaopian = fileUrls;
    },
  }
};
</script>
<style lang="scss" scoped>
	.amap-wrapper {
		width: 100%;
		height: 500px;
	}
	
	.search-box {
		position: absolute;
	}
	
	.el-date-editor.el-input {
		width: auto;
	}
	
	.add-update-preview .el-form-item /deep/ .el-form-item__label {
	  	  padding: 0 10px 0 0;
	  	  color: #666;
	  	  font-weight: 500;
	  	  width: 180px;
	  	  font-size: 16px;
	  	  line-height: 40px;
	  	  text-align: right;
	  	}
	
	.add-update-preview .el-form-item /deep/ .el-form-item__content {
	  margin-left: 180px;
	}
	
	.add-update-preview .el-input /deep/ .el-input__inner {
	  	  border: 1px solid #d3e5f3;
	  	  border-radius: 4px;
	  	  padding: 0 12px;
	  	  box-shadow: 1px 2px 3px #eee;
	  	  outline: none;
	  	  color: #666;
	  	  width: auto;
	  	  font-size: 16px;
	  	  min-width: 400px;
	  	  height: 40px;
	  	}
	
	.add-update-preview .el-select /deep/ .el-input__inner {
	  	  border: 1px solid #d3e5f3;
	  	  border-radius: 4px;
	  	  padding: 0 10px;
	  	  box-shadow: 1px 2px 3px #eee;
	  	  outline: none;
	  	  color: #666;
	  	  width: auto;
	  	  font-size: 16px;
	  	  height: 40px;
	  	}
	
	.add-update-preview .el-date-editor /deep/ .el-input__inner {
	  	  border: 1px solid #d3e5f3;
	  	  border-radius: 4px;
	  	  padding: 0 10px 0 30px;
	  	  box-shadow: 1px 2px 3px #eee;
	  	  outline: none;
	  	  color: #666;
	  	  width: auto;
	  	  font-size: 16px;
	  	  height: 40px;
	  	}
	
	.add-update-preview /deep/ .el-upload--picture-card {
		background: transparent;
		border: 0;
		border-radius: 0;
		width: auto;
		height: auto;
		line-height: initial;
		vertical-align: middle;
	}
	
	.add-update-preview /deep/ .upload .upload-img {
	  	  border: 1px solid #d3e5f3;
	  	  cursor: pointer;
	  	  border-radius: 4px;
	  	  box-shadow: 1px 2px 3px #eee;
	  	  color: #d3e5f3;
	  	  background: #fff;
	  	  width: 200px;
	  	  font-size: 32px;
	  	  line-height: 80px;
	  	  text-align: center;
	  	  height: 80px;
	  	}
	
	.add-update-preview /deep/ .el-upload-list .el-upload-list__item {
	  	  border: 1px solid #d3e5f3;
	  	  cursor: pointer;
	  	  border-radius: 4px;
	  	  box-shadow: 1px 2px 3px #eee;
	  	  color: #d3e5f3;
	  	  background: #fff;
	  	  width: 200px;
	  	  font-size: 32px;
	  	  line-height: 80px;
	  	  text-align: center;
	  	  height: 80px;
	  	}
	
	.add-update-preview /deep/ .el-upload .el-icon-plus {
	  	  border: 1px solid #d3e5f3;
	  	  cursor: pointer;
	  	  border-radius: 4px;
	  	  box-shadow: 1px 2px 3px #eee;
	  	  color: #d3e5f3;
	  	  background: #fff;
	  	  width: 200px;
	  	  font-size: 32px;
	  	  line-height: 80px;
	  	  text-align: center;
	  	  height: 80px;
	  	}
	
	.add-update-preview .el-textarea /deep/ .el-textarea__inner {
	  	  border: 1px solid #d3e5f3;
	  	  border-radius: 4px;
	  	  padding: 12px;
	  	  box-shadow: 1px 2px 3px #eee;
	  	  outline: none;
	  	  color: #666;
	  	  width: 400px;
	  	  font-size: 16px;
	  	  min-height: 120px;
	  	  height: auto;
	  	}
</style>
