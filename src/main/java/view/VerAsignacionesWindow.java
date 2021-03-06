package view;

import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.tables.Column;
import org.uqbar.arena.widgets.tables.Table;
import org.uqbar.arena.windows.Dialog;
import org.uqbar.arena.windows.WindowOwner;

import model.Asignacion;
import viewModel.ValidacionVM;
import viewModel.VerAsignacionesVM;

public class VerAsignacionesWindow extends Dialog<VerAsignacionesVM>{

	public VerAsignacionesWindow(WindowOwner owner, ValidacionVM validacionVM) {
		super(owner, new VerAsignacionesVM());
		this.getModelObject().setToken(validacionVM.getToken());
		this.getModelObject().cargarNotas();
	}

	@Override
	protected void createFormPanel(Panel mainPanel) {
		this.setTitle("Ver asignaciones");

		Table<Asignacion> tablaAsignaciones = new Table<Asignacion>(mainPanel, Asignacion.class);
		tablaAsignaciones.setNumberVisibleRows(20);
		
		tablaAsignaciones.bindItemsToProperty("asignaciones");
		
		Column<Asignacion> columnaId = new Column<Asignacion>(tablaAsignaciones);
		columnaId.setTitle("Identificacion");
		columnaId.setFixedSize(100);
		columnaId.bindContentsToProperty("id");
		
		Column<Asignacion> columnaTitle = new Column<Asignacion>(tablaAsignaciones);
		columnaTitle.setTitle("Titulo");
		columnaTitle.setFixedSize(100);
		columnaTitle.bindContentsToProperty("title");
		
		Column<Asignacion> columnaDescripcion = new Column<Asignacion>(tablaAsignaciones);
		columnaDescripcion.setTitle("Descripcion");
		columnaDescripcion.setFixedSize(200);
		columnaDescripcion.bindContentsToProperty("description");
		
		Column<Asignacion> columnaNotaActual = new Column<Asignacion>(tablaAsignaciones);
		columnaNotaActual.setTitle("Nota");
		columnaNotaActual.setFixedSize(100);
		columnaNotaActual.bindContentsToProperty("notaActual");
		
		Column<Asignacion> columnaEstado = new Column<Asignacion>(tablaAsignaciones);
		columnaEstado.setTitle("Estado");
		columnaEstado.setFixedSize(100);
		columnaEstado.bindContentsToProperty("estadoNota");
		
	
	}
}
