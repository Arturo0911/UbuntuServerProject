export interface iUserProfile {
    userId: number,
    userName: string,
    userLastName: string,
    users: iUserProfile[],
    posts: iPosts[],
    email: string,
    imageUrl: string,
    phoneNumber: string,
    preference: iPreferences,
    userBirth: string,
    userCreatedAt: string,
    gender: string,
    password: string,
    status: string

}

export interface iPosts {
    postId: number,
    postTitle: string,
    postContent: string,
    postDate: string,
    userLikes: iUserProfile[],
    postModify: string | null,

}


// to be shipped
export interface iPreferences {
    preferencesId: number,
    currentlyStatus: string,
    codePreferences: string,
    ranking: number,
    experience: string
}

export interface iFormPreferences {
    currentlyStatus: string,
    codePreferences: string,
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
    posts: postFoundUser[],
    imageUrl: string,
    preferences: iPreferences
}

interface postFoundUser {
    Content: string,
    Title: string,
    Likes: number,
    CratedAt: string
}


export interface allUsers {
    imagUrl:string,
    followers: number,
    userLastName: string,
    userName: string,
    userId: number
}


// interface to make post

export interface makePost {
    postTitle:string,
    postContent: string
}