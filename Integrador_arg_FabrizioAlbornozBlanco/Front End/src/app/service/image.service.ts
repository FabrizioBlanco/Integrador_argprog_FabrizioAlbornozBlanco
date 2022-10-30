import { Injectable } from '@angular/core';
import { Storage, ref, uploadBytes, listAll, getDownloadURL, list } from '@angular/fire/storage';


@Injectable({
  providedIn: 'root'
})
export class ImageService {

  // images: string
    url: string
  constructor(private storage: Storage) {
    // this.images = ''
    this.url = ''
  } 
  upLoadImage($event: any, nombre:string){
    const file = $event.target.files[0] //capturamos la imagen en la posicion 0 del array, junto con sus datos
    const imgRef = ref(this.storage, `imagen/` + nombre)
    //Con esto subimos el archivo           
    uploadBytes(imgRef, file)
    .then(response=>{
    this.getImage() //obtiene la imagen desde firebase
    })
    .catch(error=>console.log(error))

  }

  getImage():string{
    //buscamos dentro del storage en la carpeta imagen
    const imageRef = ref(this.storage, 'imagen')
    //hacemos un listado
    list(imageRef)
    .then(async response=>{//tiene una demora, por lo tanto tarda. Si lo dejamos sin el async, no va a devolver nada.
      for(let item of response.items){
        this.url = await getDownloadURL(item) //el 'await' es para que espere un poco
        console.log("la url es:", this.url);

      }
    })
    .catch(error=>console.log(error))
    return this.url
  }

}
// upLoadImage($event: any) {
  //   const file = $event.target.files[0]
  //   console.log(file)

  //   const imgRef = ref(this.storage, `imagen/'${file.name}`)
  //   uploadBytes(imgRef, file)
  //     .then(response => console.log(response))
  //     .catch(error => console.log(error))
  // }

  // getImages(): string {
  //   //Le pasamos la referencia de la storage y le decimos en qué carpeta se guardó esa imagen
  //   const imagesRef = ref(this.storage, 'imagen')
  //   list(imagesRef)
  //     .then(async response => {
  //       console.log(response)
  //       for (let item of response.items) {
  //         const url = await getDownloadURL(item)
  //         console.log('La url de la imagen es: ' + url);

  //         this.images = url

  //       }
  //     })
  //     .catch(error => console.log(error))
  //   return this.images
  // }