
def server_messages(status_code:int) -> object:

    if status_code == 200:

        return {
            "status_code":status_code,
            "message": "Process was donde successfully"
        }
    else:
        return {
            "status_code":status_code,
            "message": "Server error internal"
        }
