#!/usr/bin/python3


FIND_USER =  "http://127.0.0.1:8080/user/findUser/{}"
CREATE_USER =  "http://127.0.0.1:8080/user/newUser"
UPDATE_USER =  "http://127.0.0.1:8080/user/updateUser"
DELETE_USER = "http://127.0.0.1:8080/user/deleteUser/{}"
GET_FOLLOWINGS = "http://127.0.0.1:8080/user/allFollowers/{}"
FOLLOW_USER = "http://127.0.0.1:8080/user/follow/{}/{}"
UNFOLLOW_USER =  "http://127.0.0.1:8080/user/unFollow/{}"


CONST_URLS = {
    "find_user": "http://127.0.0.1:8080/user/findUser/{}",
    "create_user": "http://127.0.0.1:8080/user/newUser",
    "update_user": "http://127.0.0.1:8080/user/updateUser",
    "delete_user": "http://127.0.0.1:8080/user/deleteUser/{}",
    "get_followings": "http://127.0.0.1:8080/user/allFollowers/{}",
    "follow_user": "http://127.0.0.1:8080/user/follow/{}/{}",
    "unfollow_user": "http://127.0.0.1:8080/user/unFollow/{}"
}
