from app import app
from flask import jsonify
from flask import request
import requests

# modules
from app.helpers import endpoints

# USERS ROUTES
"""Get all the users from SpringBoot"""
@app.route("/newUser", methods = ['GET'])
def get_users():
    
    request_ = requests.get("http://localhost:8080/user/test")
    print(request_.json())
    
    for x in request_.json()['response']:
        print(x)
    return "hello world"


