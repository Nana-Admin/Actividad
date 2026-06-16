package com.orangehrm.stepsdefinitions;

import com.orangehrm.questions.EmployeeValidation;
import com.orangehrm.tasks.EmployeeTasks;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import net.serenitybdd.screenplay.Actor;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.CoreMatchers.is;

public class EmployeeSteps {

    private String generateUnique(String prefix) {
        return prefix + System.currentTimeMillis() % 100000;
    }

    @Dado("que existe un empleado recien creado en el sistema")
    public void queExisteUnEmpleadoRecienCreado() {
        Actor actor = theActorInTheSpotlight();
        String firstName = generateUnique("FN");
        String lastName = generateUnique("LN");
        String fullName = firstName + " " + lastName;
        actor.remember("empFullName", fullName);
        actor.attemptsTo(
                EmployeeTasks.navigateToAddEmployee(),
                EmployeeTasks.fillEmployeeDetails(firstName, lastName),
                EmployeeTasks.saveEmployee()
        );
    }

    @Cuando("el usuario navega a la seccion de agregar empleado")
    public void elUsuarioNavegaASeccionAgregarEmpleado() {
        theActorInTheSpotlight().attemptsTo(EmployeeTasks.navigateToAddEmployee());
    }

    @Cuando("el usuario ingresa los datos del nuevo empleado {string} {string}")
    public void elUsuarioIngresaDatosNuevoEmpleado(String firstName, String lastName) {
        String uniqueFirst = firstName + System.currentTimeMillis() % 1000;
        String uniqueLast = lastName + System.currentTimeMillis() % 1000;
        theActorInTheSpotlight().remember("empFullName", uniqueFirst + " " + uniqueLast);
        theActorInTheSpotlight().attemptsTo(EmployeeTasks.fillEmployeeDetails(uniqueFirst, uniqueLast));
    }

    @Cuando("el usuario guarda el registro")
    public void elUsuarioGuardaElRegistro() {
        theActorInTheSpotlight().attemptsTo(EmployeeTasks.saveEmployee());
    }

    @Cuando("el usuario navega a la lista de empleados")
    public void elUsuarioNavegaALaListaDeEmpleados() {
        theActorInTheSpotlight().attemptsTo(EmployeeTasks.navigateToEmployeeList());
    }

    @Cuando("el usuario busca el empleado creado")
    public void elUsuarioBuscaElEmpleadoCreado() {
        String fullName = theActorInTheSpotlight().recall("empFullName");
        theActorInTheSpotlight().attemptsTo(EmployeeTasks.searchEmployeeByName(fullName));
    }

    @Cuando("el usuario busca el empleado por nombre {string}")
    public void elUsuarioBuscaEmpleadoPorNombre(String name) {
        theActorInTheSpotlight().attemptsTo(EmployeeTasks.searchEmployeeByName(name));
    }

    @Cuando("el usuario selecciona el empleado para editar")
    public void elUsuarioSeleccionaEmpleadoParaEditar() {
        theActorInTheSpotlight().attemptsTo(EmployeeTasks.clickEditEmployee());
    }

    @Cuando("el usuario actualiza el nombre del empleado a {string}")
    public void elUsuarioActualizaNombreEmpleado(String newFirstName) {
        String updated = newFirstName + System.currentTimeMillis() % 1000;
        theActorInTheSpotlight().remember("updatedName", updated);
        theActorInTheSpotlight().attemptsTo(EmployeeTasks.updateEmployeeFirstName(updated));
    }

    @Cuando("el usuario selecciona un empleado y lo elimina")
    public void elUsuarioSeleccionaEmpleadoYLoElimina() {
        theActorInTheSpotlight().attemptsTo(
                EmployeeTasks.clickRowTrashButton(),
                EmployeeTasks.confirmDelete()
        );
    }

    @Entonces("el sistema muestra un mensaje de confirmacion del empleado creado")
    public void elSistemaMuestraConfirmacionEmpleadoCreado() {
        theActorInTheSpotlight().should(
                seeThat("Employee created", EmployeeValidation.createConfirmationShown(), is(true))
        );
    }

    @Entonces("el sistema muestra la pagina de lista de empleados")
    public void elSistemaMuestraPaginaListaEmpleados() {
        theActorInTheSpotlight().should(
                seeThat("PIM page displayed", EmployeeValidation.pageDisplayed(), is(true))
        );
    }

    @Entonces("el sistema muestra la informacion del empleado en la lista")
    public void elSistemaMuestraInformacionEmpleadoEnLista() {
        String fullName = theActorInTheSpotlight().recall("empFullName");
        theActorInTheSpotlight().should(
                seeThat("Employee in list", EmployeeValidation.isInList(fullName), is(true))
        );
    }

    @Entonces("el sistema confirma la actualizacion del empleado")
    public void elSistemaConfirmaActualizacionDelEmpleado() {
        theActorInTheSpotlight().should(
                seeThat("Employee updated", EmployeeValidation.isUpdated(), is(true))
        );
    }

    @Entonces("el sistema elimina el empleado de la lista")
    public void elSistemaEliminaEmpleadoDeLaLista() {
        theActorInTheSpotlight().should(
                seeThat("Employee deleted", EmployeeValidation.isDeleted(), is(true))
        );
    }
}
