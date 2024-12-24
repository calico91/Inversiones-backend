package com.cblandon.inversiones.imagen_cliente.dto;

import java.util.Arrays;

public record ImagenDTO(byte[] base64,
                        String extension) {

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        ImagenDTO that = (ImagenDTO) obj;
        return Arrays.equals(base64, that.base64) &&
                (extension == null ? that.extension == null : extension.equals(that.extension));
    }

    @Override
    public int hashCode() {
        int result = Arrays.hashCode(base64);
        result = 31 * result + (extension != null ? extension.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "ImagenDTO{" +
                "base64=" + Arrays.toString(base64) +
                ", extension='" + extension + '\'' +
                '}';
    }
}
