import { Component } from '@angular/core';
import { AppService } from './app.service';
import { MatInputModule } from "@angular/material/input";
import { Observable, takeUntil, CompletionObserver } from 'rxjs';
import { FormsModule } from '@angular/forms';
import { HttpHeaders } from '@angular/common/http';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss'],

})
export class AppComponent {
  title = 'Wise Step';

  //input
  tinyUrl! : string;


  constructor(private appService: AppService) { }

  shortenURL(domain: HTMLInputElement): void {
    console.log(`${domain.value}`);
    
    const input = domain.value;

    this.appService.urlShortner(input).subscribe((response) => {
      if(response.status == 200){
        alert(response.body)
      }
    }
  );

  }




}
