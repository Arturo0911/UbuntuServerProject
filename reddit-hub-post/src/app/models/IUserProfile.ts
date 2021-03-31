export interface iUserProfile {
    userId: number,
    userName: string,
    userLastName: string,
    users: iUserProfile[],
    posts:iPosts[],
    email:string,
    imageUrl:string,
    phoneNumber:string,
    preferences: iPreferences,
    userBirth: string,
    userCreatedAt:string,
    gender:string,
    password:string,
    status:string

}

export interface iPosts {
    postId: number,
    postTitle: string,
    postContent:string,
    postDate:string,
    userLikes: iUserProfile[],
    postModify: string | null,

}

export interface iPreferences {
    preferencesId: number,
    currentlyStatus: string,
    codePreferences:string,
    ranking: number,
    experience: string
}


export interface findUser {
    userName: string,
    userLastName: string
}

export interface FoundUser {
    userId: number,
    userName: string,
    userLastName: string,
    followers: number,
    posts:postFoundUser[],
    email:string,
    imageUrl:string,
    phoneNumber:string,
    preferences: iPreferences,
    userBirth: string,
}

interface postFoundUser {
    Content: string,
    Title: string,
    Likes: number,
    CratedAt: string
}