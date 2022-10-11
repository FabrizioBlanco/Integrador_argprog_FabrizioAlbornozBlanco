import { HttpEvent, HttpHandler, HttpRequest, HTTP_INTERCEPTORS } from "@angular/common/http";
import { TokenService } from "./token.service";
import { Observable } from "rxjs";
import { Injectable } from "@angular/core";

@Injectable({
    providedIn: "root"
})
//Esto es para mantener continuidad con las sesiones en distintos EndPoints
export class InterceptorService{
    constructor(private tokenService: TokenService){}
    intercept(req: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>>{
        let intreq = req
        const token = this.tokenService.getToken()
        if(token!=null){
            intreq = req.clone({
                headers: req.headers.set('Authorization', "Bearer" + token)
            })
        }
        return next.handle(intreq)
    }
}

export const interceptorProvider = [{
    provide: HTTP_INTERCEPTORS, 
    useClass: InterceptorService, 
    multi: true
}]