export class persona{
    id?: number; //Se indica así que el dato no es necesario
    name: String;
    surname: String;
    img: String;

    constructor(name:String, surname:String, img:String){
        this.name = name;
        this.surname = surname;
        this.img = img;
    }
}