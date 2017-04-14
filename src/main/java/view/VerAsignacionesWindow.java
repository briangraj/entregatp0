package view;

import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.TextBox;
import org.uqbar.arena.widgets.tables.Column;
import org.uqbar.arena.widgets.tables.Table;
import org.uqbar.arena.windows.Dialog;
import org.uqbar.arena.windows.WindowOwner;

import model.Asignacion;
import viewModel.VerAsignacionesVM;

public class VerAsignacionesWindow extends Dialog<VerAsignacionesVM>{

	public VerAsignacionesWindow(WindowOwner owner) {
		super(owner, new VerAsignacionesVM());
	}

	@Override
	protected void createFormPanel(Panel mainPanel) {
		
		this.setTitle("Ver asignaciones");

		new TextBox(mainPanel).bindValueToProperty("token");
		
		Table<Asignacion> tablaAsignaciones = new Table<Asignacion>(mainPanel, Asignacion.class);
		tablaAsignaciones.setNumberVisibleRows(10);
		
		tablaAsignaciones.bindItemsToProperty("asignaciones");
		//tablaAsignaciones.bindValueToProperty("asignaciones");
		
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
		
		new Button(mainPanel).setCaption("Ver asignaciones")
							 .onClick(()->this.getModelObject().cargarNotas());
		
	}
}
