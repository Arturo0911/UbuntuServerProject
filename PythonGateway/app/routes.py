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
# OK
@app.route("/all_users", methods = ['GET'])
def get_users():
    
    request_ = requests.get(endpoints.GET_ALL_USERS)
    return jsonify(request_.json()['response'])

# OK
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

# OK
@app.route("/update_user", methods = ['PUT'])
def update_user():

    status_code = requests_resolvers.handler_request(endpoints.UPDATE_USER,
        request.json,request.method )
    return jsonify(server_messages.server_messages(status_code))

# OK
@app.route("/search_user/<user_id>", methods = ['GET']) # findUser/{userId} => int
def search_user(user_id:int):
    
    get_object = requests_resolvers.handler_request_path_variable(user_id, 
        request.method)
    return jsonify(get_object)

# OK
@app.route("/delete_user/<user_id>", methods = ['DELETE']) # findUser/{userId} => int
def delete_user(user_id:int):

    status_code = requests_resolvers.handler_request_path_variable(user_id,
        request.method)
    return jsonify(server_messages.server_messages(status_code))


# FOLLOWERS ROUTES


# OK
@app.route("/all_followers/<user_id>", methods = ['GET'])
def get_all_followings(user_id):
    
    return jsonify(requests_resolvers.get_all_followings(int(user_id)))

# OK
@app.route("/follow/<user_id>/<user_to_follow>", methods = ['POST'])
def follow_user(user_id:int, user_to_follow:int):

    status_code = requests_resolvers.follow_user(user_id, user_to_follow)
    return jsonify(server_messages.server_messages(status_code))

# OK
@app.route("/unfollow/<user_id>/<user_to_unfollow>", methods = ['DELETE'])
def un_follow(user_id:int, user_to_unfollow:int):

    status_code = requests_resolvers.unfollow_user(user_id,user_to_unfollow)
    return jsonify(server_messages.server_messages(status_code))