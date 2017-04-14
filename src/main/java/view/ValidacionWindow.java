package view;

import org.uqbar.arena.bindings.NotNullObservable;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.TextBox;
import org.uqbar.arena.windows.Dialog;
import org.uqbar.arena.windows.SimpleWindow;
import org.uqbar.arena.windows.WindowOwner;

import viewModel.ValidacionVM;

public class ValidacionWindow extends SimpleWindow<ValidacionVM>{
	
	public ValidacionWindow(WindowOwner parent) {
		super(parent, new ValidacionVM());
	}
	
	@Override
	protected void addActions(Panel panelActions) {
		Button obtenerAsignaciones = new Button(panelActions)
		.setCaption("Ver asignaciones")
		.onClick(() -> this.obtenerAsignaciones());
		
		NotNullObservable elementSelected = new NotNullObservable("habilitarOpciones");
		obtenerAsignaciones.bindEnabled(elementSelected);
	}
	
	@Override
	protected void createFormPanel(Panel mainPanel) {
		Panel form = new Panel(mainPanel);
		this.setTitle("Validacion del token");
		
		
		new TextBox(form).setWidth(600).bindValueToProperty("token");
		
		new Label(form).bindValueToProperty("estado");

		new Button(form)
		.setCaption("Validar")
		.onClick(()-> this.getModelObject().validar());
	
		
	}
	
		
	public void obtenerAsignaciones(){
		Dialog<?> dialog = new VerAsignacionesWindow(this);
		dialog.open();
		dialog.onAccept(() -> {});
	}
	


}
