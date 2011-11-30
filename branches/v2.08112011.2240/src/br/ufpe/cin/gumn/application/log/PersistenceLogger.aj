package br.ufpe.cin.gumn.application.log;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import br.ufpe.cin.gumn.application.persistence.util.AbstractDAO;

/**
 * @author gertmuller88
 *
 */
public aspect PersistenceLogger {
	private static File file;
	private static FileOutputStream fos;
	private static PrintWriter out;
	private static SimpleDateFormat sdf;
	
	/**
	 * 
	 */
	public void updateFile() {
		try {
			sdf = new SimpleDateFormat("yyyy-MM-dd");
			file = new File("WebContent/logs/persistence." + sdf.format(new Date()) + ".txt");
			fos = new FileOutputStream(file, true);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		out = new PrintWriter(fos);
	}
	
	pointcut persist(Object o) : execution(* AbstractDAO+.persist(*)) && args(o);
	pointcut merge(Object o) : execution(* AbstractDAO+.merge(*)) && args(o);
	pointcut remove(Object o) : execution(* AbstractDAO+.remove(*)) && args(o);
	pointcut find(Object o) : execution(* AbstractDAO+.find(*)) && args(o);
	
	before(Object o) : persist(o) {
		this.updateFile();
		out.println("/--------------------------------------------- PERSIST ---------------------------------------------/");
		out.println(new Date().toString() + " - Persisting " + o.toString() + ".");
		out.flush();
	}
	
	after(Object o) returning(Object ob) : persist(o) {
		this.updateFile();
		out.println(new Date().toString() + " - Persisting return of " + o.toString() + ": " + ob.toString() + ".");
		out.flush();
	}
	
	after(Object o) throwing(Exception e) : persist(o) {
		this.updateFile();
		out.println(new Date().toString() + " - Exception in persisting of " + o.toString() + ".");
		out.println("								   - Exception Message: " + e.getMessage());
		out.println("								   - Exception Cause: " + e.getCause().getMessage());
		out.flush();
	}
	
	after(Object o) : persist(o) {
		this.updateFile();
		out.println(new Date().toString() + " - End persisting " + o.toString() + ".");
		out.println("/---------------------------------------------------------------------------------------------------/");
		out.println();
		out.flush();
	}
	
	before(Object o) : merge(o) {
		System.out.append("/----------------------------------------- MERGE -----------------------------------------/");
		System.out.append("Atualizando objeto " + o.toString());
	}
	
	after(Object o) returning(Object ob) : merge(o) {
		System.out.println("Retorno da atualização do objeto " + o.toString() + ": " + ob.toString());
	}
	
	after(Object o) throwing(Exception e) : merge (o) {
		System.out.println("Falha na atualização do objeto " + o.toString() + ".");
		System.out.println("Exceção: " + e.getMessage());
		System.out.println("Causa: " + e.getCause().getMessage());
	}
	
	after(Object o) : merge(o) {
		System.out.println("Fim da atualização do objeto " + o.toString());
		System.out.println("/-----------------------------------------------------------------------------------------/");
	}
}
