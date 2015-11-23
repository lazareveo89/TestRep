var task = angular.module('task1', []);

task.controller('userController', ['$scope',function($scope) {
    $scope.clickMe = false;

    $scope.showClickMe = function() {
        $scope.clickMe = true;
    };

}]);

task.directive('smsSettings', function() {
    return {
        restrict: 'E',
        replace: true,
        template: '<div>' +
            '<div class="modal fade" id="smsSettings" tabindex="-1" + role = "dialog" aria-labelledby = "myModalLabel" aria-hidden = "true" > ' +
            '<div ng-click="close()">X</div>' + 
             '<ul class="nav nav-tabs" role="tablist">' +
               '<li role="presentation" class="active"><a href="#tempates" aria-controls="home" role="tab" data-toggle="tab">Tempates</a></li>' +
               '<li role="presentation"><a href="#settings" aria-controls="settings" role="tab" data-toggle="tab">Settings</a></li>' +
             '</ul>' +
             '<div class="tab-content">' +
               '<div role="tabpanel" class="tab-pane active" id="tempates">' +
                   '<label>SMS Text:</label>' +
                   '<textarea rows="8" ng-model="smsSettings.smsText"></textarea>' +
                   '<label class="checkbox">' +
                       '<span>Send</span><input type="text" ng-model="smsSettings.daysBeforeEvent"><span>day(s) before event</span>' +
                   '</label>' +
                   '<label class="checkbox inline">' +
                       '<input type="checkbox" ng-model="smsSettings.activateSMS"> Activate SMS' +
                   '</label>' +
               '</div>' +
                '<div role="tabpanel" class="tab-pane" id="settings">' +
                   '<form class="form-horizontal">' +
                       '<div class="control-group">' +
                        '<label class="control-label">Ip</label>' +
                        '<div class="controls">' +
                           '<input type="text" ng-model="smsSettings.serverIP">' +
                         '</div>' +
                       '</div>' +
                       '<div class="control-group">' +
                         '<label class="control-label">port</label>' +
                         '<div class="controls">' +
                           '<input type="text" ng-model="smsSettings.port">' +
                         '</div>' +
                       '</div>' +
                       '<div class="control-group">' +
                         '<label class="control-label">login</label>' +
                         '<div class="controls">' +
                           '<input type="text" ng-model="smsSettings.login">' +
                         '</div>' +
                       '</div>' +
                       '<div class="control-group">' +
                         '<label class="control-label" for="inputPassword">Password</label>' +
                         '<div class="controls">' +
                           '<input type="password" ng-model="smsSettings.password">' +
                         '</div>' +
                       '</div>' +
                     '</form>' +
                 '</div>' +
             '</div>' +
             '<p class="sms-buttons">' +
               '<button class="btn btn-primary" type="button" ng-click="save()">Save</button>' +
               '<button class="btn" type="button" ng-click="close()">Close</button>' +
             '</p>' +
             '</div>' +
            '</div>',
        controller: function($scope, $http) {

            var _closePopup = function(){
                $scope.clickMe = false;
                $("#smsSettings").modal('hide');
            };

            $scope.smsSettings = {
                smsText: '',
                daysBeforeEvent: 0,
                activateSMS: false,
                serverIP: '',
                port: '',
                login: '',
                password: ''
            };

            $scope.save = function() {
                var requestData = $scope.smsSettings;
               $http({
                        url: 'http://127.0.0.1:7525/task1-serverside/putSms/sms',
                        method: "POST",
                        params: smsSettings,
                        dataType: 'json',
                        headers: {
                            'Accept': 'application/json',
                            'Content-Type': 'application/json',
                            'Access-Control-Allow-Origin': "*"
                        }
                    })
                    .then(function(response) {
                            console.log('sucsses');
                            _closePopup();
                        },
                        function(reson) {
                            console.log('fail');
                            _closePopup();
                        });
            };

            $scope.close = function(){
                _closePopup();
            };

            $scope.cancel = function() {
               _closePopup();
            };

            $scope.$watch('clickMe', function() {
                if ($scope.clickMe) {
                    $("#smsSettings").modal('show');
                };
            });
        }
    };
});