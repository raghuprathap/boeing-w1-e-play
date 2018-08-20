import { Injectable } from '@angular/core';
import { MovieEvent } from "./movie-event";
import { HttpClient } from "@angular/common/http";
import { Observable } from "rxjs";
@Injectable({
  providedIn: 'root'
})
export class MovieEventService {
  private _url: string = "http://172.23.238.220:8094/api/v1/";
  constructor(private http: HttpClient) {}

  saveMovieEvent(movieEvent: MovieEvent): Observable<MovieEvent> {
    return this.http.post<MovieEvent>(this._url+"upstream/movieEvent", movieEvent);
  }
}
