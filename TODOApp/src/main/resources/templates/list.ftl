<div class="generic-container">
    <div class="panel panel-default">
        <!-- Default panel contents -->
        <div class="panel-heading"><span class="lead"> ToDo Task App </span></div>
        <div class="panel-body">
            <div class="formcontainer">
                <div class="alert alert-success" role="alert" ng-if="ctrl.successMessage">{{ctrl.successMessage}}</div>
                <div class="alert alert-danger" role="alert" ng-if="ctrl.errorMessage">{{ctrl.errorMessage}}</div>
                <form ng-submit="ctrl.submit()" name="myForm" class="form-horizontal">
                    <input type="hidden" ng-model="ctrl.user.id" />
                    <div class="row">
                        <div class="form-group col-md-12">
                            <label class="col-md-2 control-lable" for="uname">Todo Task</label>
                            <div class="col-md-7">
                                <input type="text" ng-model="ctrl.user.todoTask" id="uname" class="username form-control input-sm" placeholder="Enter Todo Task" required ng-minlength="3"/>
                            </div>
                        </div>
                    </div>
 
                    <div class="row">
                        <div class="form-group col-md-12">
                            <label class="col-md-2 control-lable" for="age">Description</label>
                            <div class="col-md-7">
                                <input type="text" ng-model="ctrl.user.todoTaskDesc" id="age" class="form-control input-sm" placeholder="Enter Todo Description."/>
                            </div>
                        </div>
                    </div>
     
                    <div class="row">
                        <div class="form-group col-md-12">
                            <label class="col-md-2 control-lable" for="salary">Task Status</label>
                            <div class="col-md-7">
                                <input type="text" ng-model="ctrl.user.todoTaskStatus" id="salary" class="form-control input-sm" placeholder="Enter todo Status."/>
                            </div>
                        </div>
                    </div>
 
                    <div class="row">
                        <div class="form-actions floatRight">
                            <input type="submit"  value="{{!ctrl.user.id ? 'Add' : 'Update'}}" class="btn btn-primary btn-sm"> <!-- ng-disabled="myForm.$invalid || myForm.$pristine" -->
                            <button type="button" ng-click="ctrl.reset()" class="btn btn-warning btn-sm" ng-disabled="myForm.$pristine">Reset Form</button>
                        </div>
                    </div>
                </form>
            </div>
        </div>    
    </div>
    <div class="panel panel-default">
        <!-- Default panel contents -->
        <div class="panel-heading"><span class="lead">List of Todo Task </span></div>
        <div class="panel-body">
            <div class="table-responsive">
                <table class="table table-hover">
                    <thead>
                    <tr>
                        <th>ID</th>
                        <th>Todo Task</th>
                        <th>Todo Task Description</th>
                        <th>Todo Task Status</th>
                        <th width="100"></th>
                        <th width="100"></th>
                    </tr>
                    </thead>
                    <tbody>
                    <tr ng-repeat="u in ctrl.getAllUsers()">
                        <td>{{u.id}}</td>
                        <td>{{u.todoTask}}</td>
                        <td>{{u.todoTaskDesc}}</td>
                        <td>{{u.todoTaskStatus}}</td>
                        <td><button type="button" ng-click="ctrl.editUser(u.id)" class="btn btn-success custom-width">Edit</button></td>
                        <td><button type="button" ng-click="ctrl.removeUser(u.id)" class="btn btn-danger custom-width">Remove</button></td>
                    </tr>
                    </tbody>
                </table>      
            </div>
        </div>
    </div>
</div>