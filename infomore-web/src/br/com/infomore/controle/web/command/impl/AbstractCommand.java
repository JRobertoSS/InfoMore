
package br.com.infomore.controle.web.command.impl;

import br.com.infomore.controle.web.command.ICommand;
import br.com.infomore.core.IFachada;
import br.com.infomore.core.impl.controle.Fachada;



public abstract class AbstractCommand implements ICommand {

	protected IFachada fachada = new Fachada();

}
