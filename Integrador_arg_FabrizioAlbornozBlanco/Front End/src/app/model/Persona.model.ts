export class persona{
    id?: number //Se indica así que el dato no es necesario
    name: string
    surname: string
    img: string

    constructor(name:string, surname:string, img:string){
        this.name = name
        this.surname = surname
        this.img = img
    }
}