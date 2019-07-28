appController.controller('TaskController',
    ['$http', function($http){

        var self = this;
        self.bastionHostname = "";
        self.bastionUsername = "";
        self.bastionToken = "";

        self.addBastion = function(){

            $http.get('./keystore/message_key_pub').then(function (response) {
                var keyMessage = response.data;
                var pubModulus = keyMessage.split("exponent=")[0].split("=")[1];
                var pubExponent = keyMessage.split("exponent=")[1];

                var rsa = new RSAKEy();
                rsa.setPublic(pubModulus, pubExponent);

                var encryptToken = rsa.encrypt(self.bastionToken);

                $http({
                    method: 'POST',
                    url: './registerBastion',
                    params:{
                        "bastionIp": self.bastionHostname,
                        "bastionUser": self.bastionUsername,
                        "bastionToken": encryptToken
                    }
                }).then(function successCallback(response) {
                    // this callback will be called asynchronously
                    // when the response is available
                }, function errorCallback(response) {
                    // called asynchronously if an error occurs
                    // or server returns response with an error status.
                });
            });
        };
    }
]);