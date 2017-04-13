package view;

import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.TextBox;
import org.uqbar.arena.widgets.tables.Column;
import org.uqbar.arena.widgets.tables.Table;
import org.uqbar.arena.windows.Dialog;
import org.uqbar.arena.windows.WindowOwner;

import model.Asignacion;
import model.Asignaciones;
import viewModel.VerAsignacionesVM;

public class VerAsignacionesWindow extends Dialog<VerAsignacionesVM>{

	public VerAsignacionesWindow(WindowOwner owner) {
		super(owner, new VerAsignacionesVM());
	}

	@Override
	protected void createFormPanel(Panel mainPanel) {
		//Panel form = new Panel(mainPanel);

		new TextBox(mainPanel).bindValueToProperty("token");
		
		Table tablaAsignaciones = new Table<Asignaciones>(mainPanel, Asignaciones.class);
		tablaAsignaciones.setHeight(300);
		
		//tablaAsignaciones.bindItemsToProperty("asignacion");
		tablaAsignaciones.bindValueToProperty("asignaciones");
		
		Column<Asignaciones> columnaId = new Column<Asignaciones>(tablaAsignaciones);
		columnaId.setTitle("Identificacion");
		columnaId.setFixedSize(100);
		columnaId.bindContentsToProperty("id");
		//columnaId.setFixedSize(50);
		
		Column<Asignaciones> columnaTitle = new Column<Asignaciones>(tablaAsignaciones);
		columnaTitle.setTitle("Titulo");
		//columnaTitle.setWeight();
		
		Column<Asignaciones> columnaDescripcion = new Column<Asignaciones>(tablaAsignaciones);
		columnaDescripcion.setTitle("Descripcion");
		
		//tablaAsignaciones.setHeight(300);
		//tablaAsignaciones.setWidth(600);
		
		new Button(mainPanel).setCaption("obtener")
						.onClick(()->this.getModelObject().cargarNotas())
						.setWidth(600);
		
		
	}
}
