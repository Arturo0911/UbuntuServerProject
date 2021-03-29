export interface iUser {
    userName: string,
    userLastName: string,
    userBirth: Date | 'dd/MM/yyyy',
    gender: string,
    phoneNumber: string,
    status: string,
    email: string,
    password: string
  }