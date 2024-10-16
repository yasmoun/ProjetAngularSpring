import { Injectable } from '@angular/core';
import { Oeuvre } from '../model/oeuvre.model';
import { Exposition } from '../model/exposition.model';
import { Observable } from 'rxjs';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { ExpositionWrapper } from '../model/ExpositionWrapped.model';


const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' }),
};

@Injectable({
  providedIn: 'root',
})
export class OeuvreService {
  oeuvres: Oeuvre[] = [];
  oeuvre!: Oeuvre;
  expositions: Exposition[] = [];

  apiURL: string = 'http://localhost:8080/oeuvres/api';
  apiURLExp: string = 'http://localhost:8080/oeuvres/exp';

  constructor(private http: HttpClient) {}

  listeOeuvre(): Observable<Oeuvre[]> {
    return this.http.get<Oeuvre[]>(this.apiURL);
  }

  supprimerOeuvre(id: number) {
    const url = `${this.apiURL}/${id}`;
    return this.http.delete(url, httpOptions);
  }
  ajouterOeuvre(prod: Oeuvre): Observable<Oeuvre> {
    return this.http.post<Oeuvre>(this.apiURL, prod, httpOptions);
  }

  /* supprimerOeuvre(oeuv: Oeuvre) {
    //supprimer le produit prod du tableau produits
    const index = this.oeuvres.indexOf(oeuv, 0);
    if (index > -1) {
      this.oeuvres.splice(index, 1);
    }
    //ou Bien
      this.produits.forEach((cur, index) => {
         if(prod.idProduit === cur.idProduit) {
               this.produits.splice(index, 1);
            }
      });
  }*/

  consulterOeuvre(id: number): Observable<Oeuvre> {
    const url = `${this.apiURL}/${id}`;
    return this.http.get<Oeuvre>(url);
  }

  updateOeuvre(prod: Oeuvre): Observable<Oeuvre> {
    const url = `${this.apiURL}/${prod.idOeuvre}`; // Assurez-vous que l'ID de l'œuvre est inclus dans l'URL
    return this.http.put<Oeuvre>(url, prod, httpOptions);
  }

  trierOeuvres() {
    this.oeuvres = this.oeuvres.sort((n1, n2) => {
      if (n1.idOeuvre! > n2.idOeuvre!) {
        return 1;
      }
      if (n1.idOeuvre! < n2.idOeuvre!) {
        return -1;
      }
      return 0;
    });
  }

  listeExpositions(): Observable<ExpositionWrapper> {
    return this.http.get<ExpositionWrapper>(this.apiURLExp);
  }

  consulterExposition(id: number): Exposition {
    return this.expositions.find((exp) => exp.idExposition == id)!;
  }

  rechercherParExposition(idExposition: number): Observable<Oeuvre[]> {
    const url = `${this.apiURL}/oeuvsExp/${idExposition}`;
    return this.http.get<Oeuvre[]>(url);
  }

  rechercherParTitre(titre: string): Observable<Oeuvre[]> {
    const url = `${this.apiURL}/oeuvresByTitle/${titre}`;
    return this.http.get<Oeuvre[]>(url);
  }
}
