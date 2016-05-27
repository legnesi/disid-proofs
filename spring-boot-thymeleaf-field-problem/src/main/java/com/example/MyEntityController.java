package com.example;

import java.util.Date;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/myEntity")
public class MyEntityController {

	@Autowired
	private MyEntityRepository repository;

	@RequestMapping(method = RequestMethod.POST, produces = MediaType.TEXT_HTML_VALUE)
	public String create(@Valid @ModelAttribute MyEntity myEntity, BindingResult result,
			RedirectAttributes redirectAttrs, Model model) {

		if (result.hasErrors()) {
			populateForm(model, myEntity);
			return "myEntity/create";
		}

		MyEntity newEntity = repository.save(myEntity);

		// Añadir los parámetros que se incluirán en la petición a la que se
		// redirige
		redirectAttrs.addAttribute("id", newEntity.getId());

		return "redirect:/myEntity/{id}";
	}

	/**
	 * Manejador de la petición HTTP asociada a la acción REST para mostrar el
	 * formulario de creación.
	 *
	 * @param model
	 *            estructura {@link Map} con los datos de la aplicación
	 *            relacionados con la petición.
	 * @return identificador de la plantilla que generará la respuesta HTML
	 */
	@RequestMapping(value = "/create-form", method = RequestMethod.GET, produces = MediaType.TEXT_HTML_VALUE)
	public String createForm(Model model) {

		// Crear una nueva instancia e incluirla en el modelo
		MyEntity myEntity =new MyEntity();
		myEntity.setDate(new Date());
		myEntity.setaDouble(1.8);

		// Incluir en el modelo datos adicionales necesarios en el formulario:
		// enumerados, etc.
		populateForm(model, myEntity);

		// Identificador de la plantilla Thymeleaf que generará la respuesta
		// HTML
		return "myEntity/create";
	}

	@RequestMapping(value = "/{myEntity}", method = RequestMethod.GET, produces = MediaType.TEXT_HTML_VALUE)
	public String show(@PathVariable MyEntity myEntity, Model model) {

		populateForm(model, myEntity);

		// Return the view to use for rendering the response
		return "myEntity/show";
	}

	@RequestMapping(method = RequestMethod.GET, produces = MediaType.TEXT_HTML_VALUE)
	public String list(Model model) {

		// Devolver la vista que contiene el listado de entidades.
		return "myEntity/list";
	}

	@RequestMapping(value = "/{myEntity}", method = RequestMethod.PUT, produces = MediaType.TEXT_HTML_VALUE)
	public String update(@Valid @ModelAttribute MyEntity myEntity, BindingResult result,
			RedirectAttributes redirectAttrs, Model model) {

		if (result.hasErrors()) {
			populateForm(model, myEntity);
			return "myEntity/edit";
		}

		MyEntity savedMyEntity = repository.save(myEntity);

		// Añadir los parámetros que se incluirán en la petición a la que se
		// redirige
		redirectAttrs.addAttribute("id", savedMyEntity.getId());

		return "redirect:/myEntity/{id}";
	}

	@RequestMapping(value = "/{myEntity}/edit-form", method = RequestMethod.GET, produces = MediaType.TEXT_HTML_VALUE)
	public String editForm(@PathVariable MyEntity myEntity, Model model) {

		// Incluir en el modelo datos adicionales necesarios en el formulario:
		// enumerados, etc.
		populateForm(model, myEntity);

		// Identificador de la plantilla Thymeleaf que generará la respuesta
		// HTML
		return "myEntity/edit";
	}

	@RequestMapping(value = "/{myEntity}/edit-form1", method = RequestMethod.GET, produces = MediaType.TEXT_HTML_VALUE)
	public String editForm1(@PathVariable MyEntity myEntity, Model model) {

		// Incluir en el modelo datos adicionales necesarios en el formulario:
		// enumerados, etc.
		populateForm(model, myEntity);

		// Identificador de la plantilla Thymeleaf que generará la respuesta
		// HTML
		return "myEntity/edit1";
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = MediaType.TEXT_HTML_VALUE)
	public String delete(@PathVariable("id") Long id, Model model) {

		repository.delete(id);

		return "redirect:/myEntity";
	}

	void populateForm(Model model,MyEntity myEntity) {
		model.addAttribute(myEntity);
	}

}
