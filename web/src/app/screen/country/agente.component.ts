import { Component, OnInit, ViewChild } from '@angular/core';
import { MatPaginator } from '@angular/material/paginator';
import { MatSort } from '@angular/material/sort';
import { MatTableDataSource } from '@angular/material/table';
import { AgenteService } from 'src/app/core/services/agente.service';

export interface AgenteInterface {
  codigo: string;
  data: string;
}

@Component({
  selector: 'app-tasks',
  templateUrl: './agente.component.html',
  styleUrls: ['./agente.component.scss'],
})
export class AgenteComponent implements OnInit {
  agentes: any[] = [];
  selectedFiles: FileList | null = null;
  displayedColumns: string[] = ['codigo', 'data'];
  dataSource!: MatTableDataSource<AgenteInterface>;

  @ViewChild(MatPaginator)
  paginator!: MatPaginator;
  @ViewChild(MatSort)
  sort!: MatSort;

  onFileSelected(event: any): void {
    this.selectedFiles = event.target.files;
    if (this.selectedFiles && this.selectedFiles.length > 0) {
      this.sendFile(this.selectedFiles);
    }
  }

  constructor(public agenteService: AgenteService) {}

  ngAfterViewInit() {
    this.dataSource.paginator = this.paginator;
    this.dataSource.sort = this.sort;
  }

  applyFilter(event: Event) {
    const filterValue = (event.target as HTMLInputElement).value;
    this.dataSource.filter = filterValue.trim().toLowerCase();

    if (this.dataSource.paginator) {
      this.dataSource.paginator.firstPage();
    }
  }
  ngOnInit() {
    this.getIndicators();
  }

  private getIndicators() {
    this.agenteService.getAgentes().subscribe((data: any[]) => {
      if (data) {
        this.agentes = data;
        this.dataSource = new MatTableDataSource(data);
        this.dataSource.paginator = this.paginator;
        this.dataSource.sort = this.sort;
      }
    });
  }

  private sendFile(file: FileList) {
    this.agenteService.sendFile(file).subscribe(
      () => {
        this.getIndicators();
        this.selectedFiles = null;
      },
      (err: any) => {
        console.log(err);
        this.selectedFiles = null;
      }
    );
  }
}
