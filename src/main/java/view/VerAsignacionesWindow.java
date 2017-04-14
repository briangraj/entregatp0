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
		//Panel form = new Panel(mainPanel);

		new TextBox(mainPanel).bindValueToProperty("token");
		
		Table<Asignacion> tablaAsignaciones = new Table<Asignacion>(mainPanel, Asignacion.class);
		tablaAsignaciones.setNumberVisibleRows(20);
		
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
		
		Column<Asignacion> columnaNotaActual = new Column<Asignacion>(tablaAsignaciones);
		columnaNotaActual.setTitle("Nota");
		columnaNotaActual.setFixedSize(100);
		//columnaNotaActual.bindContentsToProperty("nota");
		
		Column<Asignacion> columnaEstado = new Column<Asignacion>(tablaAsignaciones);
		columnaEstado.setTitle("Estado");
		columnaEstado.setFixedSize(100);
		//columnaEstado.bindContentsToProperty("estado");
		
		new Button(mainPanel).setCaption("obtener")
						.onClick(()->this.getModelObject().cargarNotas());
		
		
	}
}
