#!/usr/bin/python3

import requests
import json


HEADERS = {'Content-type': 'application/json','Accept': 'application/json'}

"""This function is only for POST & PUT method"""
def handler_request(url:str, body_to_send:dict, method:str) -> int:

    #headers = {'Content-type': 'application/json','Accept': 'application/json'}
    body = json.dumps(body_to_send)

    if method == "POST":
        try:
            users = requests.post(url, data=body, headers = HEADERS)
            return users.status_code
        except:
            return 404
    elif method == "PUT":
        try:
            users = requests.put(url, data=body, headers = HEADERS)
            return users.status_code
        except:
            return 404
    else:
        return 500


"""Exclusive funciton only to delete and search one method with parameter in the url """
def handler_request_path_variable(user_id:int, method:str )-> int:
    if method == 'DELETE':
        try:
            url = "http://127.0.0.1:8080/user/deleteUser/{}".format(int(user_id))
            users = requests.delete(url, headers = HEADERS)

            return users.status_code

        except:
            return 404
    elif method == 'GET':
        try:
            url = "http://127.0.0.1:8080/user/findUser/{}".format(int(user_id))
            users = requests.get(url, headers = HEADERS)
            return users.json()['response']

        except:
            return 404
    else:

        return 500



""" Get all the followers from one user """

def get_all_followings(user_id:int) -> dict:

    try:
        url = "http://127.0.0.1:8080/user/allFollowers/{}".format(int(user_id))
        followers = requests.get(url, headers = HEADERS)

        return followers.json()['response']
    except :
        pass

def follow_user(user_id:int, user_to_follow:int) -> int:


    try:
        url = "http://127.0.0.1:8080/user/follow/{}/{}".format(int(user_id),
            int(user_to_follow))
        user = requests.post(url, headers = HEADERS)
        return user.status_code

    except:
        return 500

def unfollow_user(user_id:int, user_to_unfollow:int) -> int:

    try:

        url = "http://127.0.0.1:8080/user/unFollow/{}/{}".format(int(user_id), 
            int(user_to_unfollow))
        users = requests.delete(url, headers = HEADERS)
        return users.status_code
    except:
        return 500