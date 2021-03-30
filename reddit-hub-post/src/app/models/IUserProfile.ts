export interface iUserProfile {
    userId: number,
    userName: string,
    userLastName: string,
    following: iUserProfile[],
    posts:iPosts[],

}

export interface iPosts {
    postId: number,
    postTitle: string,
    postContent:string,
    postCreatedAt:Date,
    postLikes: iUserProfile[]
}

export interface iPreferences {
    preferencesId: number,
    currentlyStatus: string,
    ranking: number,
    experience: string
}