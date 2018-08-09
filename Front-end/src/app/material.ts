import { MatButtonModule ,MatCheckboxModule } from '@angular/material';
import { NgModel } from '@angular/forms';
import { NgModule } from '@angular/core';
import {MatToolbarModule} from '@angular/material/toolbar';
import {MatIconModule} from '@angular/material/icon';
import {MatMenuModule} from '@angular/material/menu';
import {MatCardModule} from '@angular/material/card';
import {MatGridListModule} from '@angular/material/grid-list';
import {MatInputModule} from '@angular/material/input';
import {MatTooltipModule} from '@angular/material/tooltip';
import {MatTabsModule} from '@angular/material/tabs';
import {MatSelectModule} from '@angular/material/select';
import {MatDatepickerModule} from '@angular/material/datepicker';
import {NativeDateModule} from '@angular/material';


@NgModule({
imports: [NativeDateModule,MatDatepickerModule,MatSelectModule,MatButtonModule,MatCheckboxModule,MatToolbarModule,MatIconModule,MatMenuModule,MatCardModule,MatGridListModule,MatInputModule,MatTooltipModule,MatTabsModule],
exports: [NativeDateModule,MatDatepickerModule,MatSelectModule,MatButtonModule,MatCheckboxModule,MatToolbarModule,MatIconModule,MatMenuModule,MatCardModule,MatGridListModule,MatInputModule,MatTooltipModule,MatTabsModule]
})

export class MaterialModule{}