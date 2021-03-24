from app import app
from flask import jsonify
from flask import request
import requests
from pprint import pprint
import json


# modules
from app.helpers import endpoints
from app.helpers import server_messages




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
            new_user = {
                "userName": request.json['userName'],
                "userLastName": request.json['userLastName'],
                "userBirth": request.json['userBirth'],
                "gender": request.json['gender'],
                "phoneNumber": request.json['phoneNumber'],
                "status": request.json['status'],
                "email": request.json['email'],
                "password": request.json['password'],
            }

            response = jsonify(new_user)
            print(json.dumps(new_user))
            requests.post(endpoints.CREATE_USER,data=json.dumps(new_user))
            return jsonify(server_messages.server_messages['success'])
        except:
            return jsonify(server_messages.server_messages['error'])
    else:
        pass
