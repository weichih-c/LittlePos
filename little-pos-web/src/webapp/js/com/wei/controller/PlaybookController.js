appController.controller('playbookSelectCtrl',
    ['playbookSelectService', function(playbookSelectService){

    var self = this;
    self.selectCategoryId = '';
    self.categoryList = playbookSelectService.getCategories();
    self.playbookList = {};
    self.listPlaybooks = function(){
        self.optionListDisable();
        var cateId = self.selectCategoryId;
        self.playbookList = playbookSelectService.getPlaybooks(cateId);
    };
    self.playbookId = '';
    self.disableCVEList = true;
    self.disableOSList = true;

    self.optionListDisable = function(){
        self.disableCVEList = true;
        self.disableOSList = true;
        console.log('hi');
        if(self.selectCategoryId === 'cve'){
            self.disableCVEList = false;
        }else if(self.selectCategoryId === 'os'){
            self.disableOSList = false;
        }
    };

    self.executorList = playbookSelectService.getExecutors();
}]);