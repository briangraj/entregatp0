package view;

import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.NumericField;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.TextBox;
import org.uqbar.arena.windows.Dialog;
import org.uqbar.arena.windows.WindowOwner;

import viewModel.ActualizarEstudianteVM;
import viewModel.ValidacionVM;

public class ActualizarEstudianteWindow extends Dialog<ActualizarEstudianteVM>{
	
	public ActualizarEstudianteWindow(WindowOwner owner, ValidacionVM validacionVM){
		super(owner, new ActualizarEstudianteVM());
		this.getModelObject().setToken(validacionVM.getToken());
	}
	
	@Override
	protected void createFormPanel(Panel mainPanel) {
		this.setTitle("Actualizar datos");

		new Label(mainPanel).setText("Ingrese su legajo");
		new NumericField(mainPanel).setWidth(200).bindValueToProperty("code");
		
		new Label(mainPanel).setText("Ingrese su nombre");
		new TextBox(mainPanel).bindValueToProperty("first_name");
		
		new Label(mainPanel).setText("Ingrese su apellido");
		new TextBox(mainPanel).bindValueToProperty("last_name");
		
		new Label(mainPanel).setText("Ingrese su usuario de github");
		new TextBox(mainPanel).bindValueToProperty("github_user");
		
		new Label(mainPanel).bindValueToProperty("msjActualizacion");
		
		new Button(mainPanel).setCaption("Actualizar datos")
							 .onClick(() -> this.getModelObject().verificarDatos());
	}
}
