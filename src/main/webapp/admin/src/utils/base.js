const base = {
    get() {
        return {
            url : "http://localhost:8080/ssmbgnk6/",
            name: "ssmbgnk6",
            // 退出到首页链接
            indexUrl: 'http://localhost:8080/ssmbgnk6/front/dist/index.html'
        };
    },
    getProjectName(){
        return {
            projectName: "基于SSM的健身房管理系统"
        } 
    }
}
export default base
