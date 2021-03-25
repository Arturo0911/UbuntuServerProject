from app import app
from flask import jsonify
from flask import request
from flask import Response
import json
import requests
from pprint import pprint
from concurrent.futures import Executor

# modules
from app.helpers import endpoints
from app.helpers import server_messages
from app.helpers import requests_resolvers



# USERS ROUTES
"""Get all the users from SpringBoot"""
@app.route("/all_users", methods = ['GET'])
def get_users():
    
    request_ = requests.get(endpoints.GET_ALL_USERS)
    return jsonify(request_.json()['response'])


@app.route("/new_user", methods = ['GET','POST'])
def create_user():

    if request.method == "POST":
        try:

            ###### REPLACE FOR THE REQUEST HANDLER
            headers = {'Content-type': 'application/json','Accept': 'application/json'}
            
            body = json.dumps({
                "userName": request.json['userName'],
                "userLastName": request.json['userLastName'],
                "userBirth": request.json['userBirth'],
                "gender": request.json['gender'],
                "phoneNumber": request.json['phoneNumber'],
                "status": request.json['status'],
                "email": request.json['email'],
                "password": request.json['password']
            })
            user = requests.post("http://127.0.0.1:8080/user/newUser",data=body, headers = headers)
            ######
            return jsonify(server_messages.server_messages(user.status_code))
        except Exception as e:
            print(str(e))
            return jsonify(server_messages.server_messages(user.status_code))
    else:
        pass


@app.route("/update_user", methods = ['PUT'])
def update_user():

    print(request.method)
    status_code = requests_resolvers.handler_request(endpoints.UPDATE_USER,
        request.json,request.method )
    print(status_code)
    return jsonify(server_messages.server_messages(status_code))

@app.route("/search_user/<user_id>", methods = ['GET']) # findUser/{userId} => int
def search_user(user_id:int):
    
    print(request.method)
    get_object = requests_resolvers.handler_request_path_variable(user_id, request.method)
    print(get_object)
    return jsonify(get_object)

@app.route("/delete_user/<user_id>", methods = ['DELETE']) # findUser/{userId} => int
def delete_user(user_id:int):

    print(request.method)
    status_code = requests_resolvers.handler_request_path_variable(user_id, request.method)
    print(status_code)
    return jsonify(server_messages.server_messages(status_code))


# FOLLOWERS ROUTES



@app.route("/all_followers", methods = ['GET'])
def get_all_followings():
    pass

@app.route("/follow", methods = ['POST'])
def follow_user():
    pass

@app.route("/unfollow", methods = ['DELETE'])
def un_follow():
    pass
