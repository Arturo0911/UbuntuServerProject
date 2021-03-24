from app import app
from flask import jsonify
from flask import request
import requests
from pprint import pprint



# modules
from app.helpers import endpoints

# USERS ROUTES
"""Get all the users from SpringBoot"""
@app.route("/all_users", methods = ['GET'])
def get_users():
    
    #request_ = requests.get("http://localhost:8080/user/test")
    request_ = requests.get(endpoints.GET_ALL_USERS)
    pprint(request_.json())
    
    # for x in request_.json()['response']:
    #     print(x)
    #return "hello world"
    return jsonify(request_.json()['response'])




@app.route("new_user", methods = ['GET','POST'])
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

            return jsonify(new_user)
        except Exception as e:
            return jsonify({
                "error_message": "Processing with problems "+str(e)
            })
    else:
        pass
