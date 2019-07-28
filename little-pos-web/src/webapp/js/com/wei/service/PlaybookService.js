appService.service('playbookSelectService', function() {
    var self = this;
    self.playbookList = [
        {name:'uname.yml', value:'1'},
        {name:'whoami.yml', value:'2'},
        {name:'patchUpdate.yml', value:'3'}
    ];
    self.getCategories = function(){
        var categories = [
            { name: 'CVE', value: 'cve' },
            { name: 'OS Version', value: 'os' },
            { name: 'Playbook', value: 'playbook' }
        ];
        return categories;
    };

    self.getPlaybooks = function(categoryId) {
        if(categoryId === "playbook"){
            console.log(self.playbookList);
            return self.playbookList;
        }else{
            return null;
        }
    }

    self.getExecutors = function() {
        var executors = [
            { id:'099698', uuid:'wjcioua', username:'邱偉志'},
            { id:'099697', uuid:'ksliena', username:'練昆鑫'}
        ];
        return executors;

    };
});