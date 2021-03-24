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
            new_user = Object()
            new_user.userName = request.json['userName']
            new_user.userLastName = request.json['userLastName']
            new_user.userBirth = request.json['userBirth']
            new_user.gender = request.json['gender']
            new_user.phoneNumber = request.json['phoneNumber']
            new_user.status = request.json['status']
            new_user.email = request.json['email']
            new_user.password = request.json['password']

            #print(new_user.toJSON())
            # user_new = {
            #     "userName": request.json['userName'],
            #     "userLastName": request.json['userLastName'],
            #     "userBirth": request.json['userBirth'],
            #     "gender": request.json['gender'],
            #     "phoneNumber": request.json['phoneNumber'],
            #     "status": request.json['status'],
            #     "email": request.json['email'],
            #     "password": request.json['password']
            # }
            #response = json.dumps(new_user.toJSON())
            #print(Response(response,  mimetype="application/json"))
            headers = {'Content-type': 'application/json','Accept': 'application/json'}
            #r = requests.session()
            #req = r.get("http://127.0.0.1:8080/user/newUser",headers = headers)
            
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
            print(user.status_code)
            print(user.json())
            return jsonify(server_messages.server_messages['success'])
        except Exception as e:
            print(str(e))
            return jsonify(server_messages.server_messages['error'])
    else:
        pass
