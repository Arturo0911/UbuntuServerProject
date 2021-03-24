from app import app
from flask import jsonify
from flask import request
from flask import Response
import json
import requests
from pprint import pprint


# modules
from app.helpers import endpoints
from app.helpers import server_messages




# USERS ROUTES
"""Get all the users from SpringBoot"""
@app.route("/all_users", methods = ['GET'])
def get_users():
    
    request_ = requests.get(endpoints.GET_ALL_USERS)
    return jsonify(request_.json()['response'])



class Object:
    def toJSON(self):
        return json.dumps(self, default=lambda o: o.__dict__, 
            sort_keys=True, indent=4)


@app.route("/new_user", methods = ['GET','POST'])
def create_user():

    if request.method == "POST":
        try:

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
            return jsonify(server_messages.server_messages(user.status_code))
        except Exception as e:
            print(str(e))
            return jsonify(server_messages.server_messages(user.status_code))
    else:
        pass


@app.route("/update_user")
def update_user():
    pass

@app.route("/search_user") # findUser/{userId} => int
def search_user():
    pass


@app.route("/delete_user") # findUser/{userId} => int
def delete_user():
    pass


# FOLLOWERS ROUTES



@app.route("/all_followers")
def get_all_followings():
    pass

@app.route("/follow")
def follow_user():
    pass

@app.route("/unfollow")
def un_follow():
    pass