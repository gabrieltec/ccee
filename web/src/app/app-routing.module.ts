import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AgenteComponent } from './screen/country/agente.component';

const routes: Routes = [
  {
    path: '',
    component: AgenteComponent,
  },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
