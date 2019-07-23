package com.comit.Geometry;

public class IrregularPolygonException extends RuntimeException {
    public IrregularPolygonException(String errorMessage, Throwable err) {
        super(errorMessage, err);
    }
}
