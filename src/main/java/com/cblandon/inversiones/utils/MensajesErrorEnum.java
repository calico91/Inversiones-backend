package com.cblandon.inversiones.utils;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum MensajesErrorEnum {

    USUARIO_REGISTRADO("Usuario registrado, modifique el nombre de usuario que se encuentra ingresando", "E1"),
    ERROR_FECHA_NUEVA("La fecha nueva no puede ser menor a la fecha de la cuota", "E2"),
    NO_PUEDE_PAGAR_CUOTA_NORMAL("No puede pagar la cuota normal, realice el pago por modulo de credito", "E3"),
    CUOTA_YA_PAGADA("Cuota ya se encuentra cancelada, verifique la informacion", "E4"),
    DOCUMENTO_DUPLICADO("El documento ya se encuentra registrado", "E5"),
    CLIENTE_NO_CREADO("El cliente no se encuentra creado", "E6"),
    ERROR_FECHAS_CREDITO("Fecha credito no puede ser mayor o igual a fecha cuota", "E7"),
    ROL_NO_ENCONTRADO("El rol no existe", "E8"),
    TIPO_DATO_INCORRECTO("El tipo de dato enviado es incorrecto", "E9"),
    ERROR_PETICION("Error con la informacion suministrada", "E10"),
    DATOS_NO_ENCONTRADOS("No se encontraron resultados con los parametros de busqueda ingresados", "E11"),
    TOKEN_CADUCO("Token caduco, inicie sesion de nuevo", "E12"),
    TOKEN_INCORRECTO("Token invalido", "E13"),
    ERROR_NO_CONTROLADO("Error desconocido, contacte su administrador", "E14"),
    AUTENTICACION_BIOMETRICA_FALLIDA("Autenticacion biometrica fallida", "E15"),
    ERROR_AUTENTICACION("Usuario o contraseña invalidos", "E16"),
    PERMISO_DENEGADO("No tiene permisos para realizar esta accion", "E17"),
    USUARIO_NO_ENCONTRADO("Nombre de usuario no existe, verifique la informacion", "E17"),
    ESTADO_NO_ACTIVO("El credito no se encuentra activo, actualice la lista de creditos", "E18"),
    CONTRASENA_ANTIGUA_INCORRECTA("la contrasena actual es incorrecta", "E19"),
    ERROR_ANULAR_ABONO("No es posible anular este abono, solo puede anular el ultimo abono realizado.",
            "E20"),
    ID_ABONO_NO_EXISTE("Abono no existe.", "E21"),
    PERMISO_NO_EXISTE("El permiso solicitado no existe", "E22"),
    ERROR_RENOVAR_CREDITO("El credito que desea renovar no existe", "E23"),
    ERROR_RENOVAR_CREDITO_POR_MONTO("El valor de la renovacion debe ser mayor a 0",
            "E24"),
    CORREO_REGISTRADO("Correo registrado, verifique el correo que se encuentra ingresando", "E25"),
    USUARIO_INACTIVO("Usuario inactivo, contacte a su administrador", "E26"),
    ERROR_SALDAR_CREDITO("El valor ingresado es menor al saldo capital del credito", "E26"),
    ERROR_PAGAR_CUOTA_NORMAL("El valor a abonar no puede ser menor al valor capital de la cuota", "E27"),
    FORMATO_ARCHIVO_INVALIDO("Solo puede guardar imagenes con este tipo de extension jpg, jpeg, png, gif, bmp",
            "E27"),
    CANTIDAD_IMAGENES_NO_VALIDA("Solo puede guardar 6 imagenes por cliente ", "E27"),
    CLIENTE_SIN_IMAGENES("El cliente no tiene imagenes cargadas", "E28");


    private final String message;
    private final String codigo;
}


