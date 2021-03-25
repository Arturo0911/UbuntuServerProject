#!/usr/bin/python3

import requests
import json
"""This function is only for POST & PUT method"""
def handler_request(url:str, body_to_send:dict, method:str) -> int:

    headers = {'Content-type': 'application/json','Accept': 'application/json'}
    body = json.dumps(body_to_send)

    if method == "POST":
        try:
            users = requests.post(url, data=body, headers = headers)
            return users.status_code
        except:
            return 500
    elif method == "PUT":
        try:
            users = requests.post(url, data=body, headers = headers)
            return users.status_code
        except :
            return 500
    else:
        return "unknown request"
