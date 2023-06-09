//
// Copyright (c) ZeroC, Inc. All rights reserved.
//
//
// Ice version 3.7.8
//
// <auto-generated>
//
// Generated from file `CoffeMach.ice'
//
// Warning: do not edit this file.
//
// </auto-generated>
//

package servicios;

public interface AlarmaServicePrx extends com.zeroc.Ice.ObjectPrx
{
    default void recibirNotificacionEscasezIngredientes(ServicioAbastecimientoPrx serverProxy, String iDing, int idMaq, String idAlarma)
    {
        recibirNotificacionEscasezIngredientes(serverProxy, iDing, idMaq, idAlarma, com.zeroc.Ice.ObjectPrx.noExplicitContext);
    }

    default void recibirNotificacionEscasezIngredientes(ServicioAbastecimientoPrx serverProxy, String iDing, int idMaq, String idAlarma, java.util.Map<String, String> context)
    {
        _iceI_recibirNotificacionEscasezIngredientesAsync(serverProxy, iDing, idMaq, idAlarma, context, true).waitForResponse();
    }

    default java.util.concurrent.CompletableFuture<Void> recibirNotificacionEscasezIngredientesAsync(ServicioAbastecimientoPrx serverProxy, String iDing, int idMaq, String idAlarma)
    {
        return _iceI_recibirNotificacionEscasezIngredientesAsync(serverProxy, iDing, idMaq, idAlarma, com.zeroc.Ice.ObjectPrx.noExplicitContext, false);
    }

    default java.util.concurrent.CompletableFuture<Void> recibirNotificacionEscasezIngredientesAsync(ServicioAbastecimientoPrx serverProxy, String iDing, int idMaq, String idAlarma, java.util.Map<String, String> context)
    {
        return _iceI_recibirNotificacionEscasezIngredientesAsync(serverProxy, iDing, idMaq, idAlarma, context, false);
    }

    /**
     * @hidden
     * @param iceP_serverProxy -
     * @param iceP_iDing -
     * @param iceP_idMaq -
     * @param iceP_idAlarma -
     * @param context -
     * @param sync -
     * @return -
     **/
    default com.zeroc.IceInternal.OutgoingAsync<Void> _iceI_recibirNotificacionEscasezIngredientesAsync(ServicioAbastecimientoPrx iceP_serverProxy, String iceP_iDing, int iceP_idMaq, String iceP_idAlarma, java.util.Map<String, String> context, boolean sync)
    {
        com.zeroc.IceInternal.OutgoingAsync<Void> f = new com.zeroc.IceInternal.OutgoingAsync<>(this, "recibirNotificacionEscasezIngredientes", null, sync, null);
        f.invoke(false, context, null, ostr -> {
                     ostr.writeProxy(iceP_serverProxy);
                     ostr.writeString(iceP_iDing);
                     ostr.writeInt(iceP_idMaq);
                     ostr.writeString(iceP_idAlarma);
                 }, null);
        return f;
    }

    default void recibirNotificacionInsuficienciaMoneda(ServicioAbastecimientoPrx serverProxy, Moneda moneda, int idMaq, String idAlarma)
    {
        recibirNotificacionInsuficienciaMoneda(serverProxy, moneda, idMaq, idAlarma, com.zeroc.Ice.ObjectPrx.noExplicitContext);
    }

    default void recibirNotificacionInsuficienciaMoneda(ServicioAbastecimientoPrx serverProxy, Moneda moneda, int idMaq, String idAlarma, java.util.Map<String, String> context)
    {
        _iceI_recibirNotificacionInsuficienciaMonedaAsync(serverProxy, moneda, idMaq, idAlarma, context, true).waitForResponse();
    }

    default java.util.concurrent.CompletableFuture<Void> recibirNotificacionInsuficienciaMonedaAsync(ServicioAbastecimientoPrx serverProxy, Moneda moneda, int idMaq, String idAlarma)
    {
        return _iceI_recibirNotificacionInsuficienciaMonedaAsync(serverProxy, moneda, idMaq, idAlarma, com.zeroc.Ice.ObjectPrx.noExplicitContext, false);
    }

    default java.util.concurrent.CompletableFuture<Void> recibirNotificacionInsuficienciaMonedaAsync(ServicioAbastecimientoPrx serverProxy, Moneda moneda, int idMaq, String idAlarma, java.util.Map<String, String> context)
    {
        return _iceI_recibirNotificacionInsuficienciaMonedaAsync(serverProxy, moneda, idMaq, idAlarma, context, false);
    }

    /**
     * @hidden
     * @param iceP_serverProxy -
     * @param iceP_moneda -
     * @param iceP_idMaq -
     * @param iceP_idAlarma -
     * @param context -
     * @param sync -
     * @return -
     **/
    default com.zeroc.IceInternal.OutgoingAsync<Void> _iceI_recibirNotificacionInsuficienciaMonedaAsync(ServicioAbastecimientoPrx iceP_serverProxy, Moneda iceP_moneda, int iceP_idMaq, String iceP_idAlarma, java.util.Map<String, String> context, boolean sync)
    {
        com.zeroc.IceInternal.OutgoingAsync<Void> f = new com.zeroc.IceInternal.OutgoingAsync<>(this, "recibirNotificacionInsuficienciaMoneda", null, sync, null);
        f.invoke(false, context, null, ostr -> {
                     ostr.writeProxy(iceP_serverProxy);
                     Moneda.ice_write(ostr, iceP_moneda);
                     ostr.writeInt(iceP_idMaq);
                     ostr.writeString(iceP_idAlarma);
                 }, null);
        return f;
    }

    default void recibirNotificacionEscasezSuministro(ServicioAbastecimientoPrx serverProxy, String idSumin, int idMaq, String idAlarma)
    {
        recibirNotificacionEscasezSuministro(serverProxy, idSumin, idMaq, idAlarma, com.zeroc.Ice.ObjectPrx.noExplicitContext);
    }

    default void recibirNotificacionEscasezSuministro(ServicioAbastecimientoPrx serverProxy, String idSumin, int idMaq, String idAlarma, java.util.Map<String, String> context)
    {
        _iceI_recibirNotificacionEscasezSuministroAsync(serverProxy, idSumin, idMaq, idAlarma, context, true).waitForResponse();
    }

    default java.util.concurrent.CompletableFuture<Void> recibirNotificacionEscasezSuministroAsync(ServicioAbastecimientoPrx serverProxy, String idSumin, int idMaq, String idAlarma)
    {
        return _iceI_recibirNotificacionEscasezSuministroAsync(serverProxy, idSumin, idMaq, idAlarma, com.zeroc.Ice.ObjectPrx.noExplicitContext, false);
    }

    default java.util.concurrent.CompletableFuture<Void> recibirNotificacionEscasezSuministroAsync(ServicioAbastecimientoPrx serverProxy, String idSumin, int idMaq, String idAlarma, java.util.Map<String, String> context)
    {
        return _iceI_recibirNotificacionEscasezSuministroAsync(serverProxy, idSumin, idMaq, idAlarma, context, false);
    }

    /**
     * @hidden
     * @param iceP_serverProxy -
     * @param iceP_idSumin -
     * @param iceP_idMaq -
     * @param iceP_idAlarma -
     * @param context -
     * @param sync -
     * @return -
     **/
    default com.zeroc.IceInternal.OutgoingAsync<Void> _iceI_recibirNotificacionEscasezSuministroAsync(ServicioAbastecimientoPrx iceP_serverProxy, String iceP_idSumin, int iceP_idMaq, String iceP_idAlarma, java.util.Map<String, String> context, boolean sync)
    {
        com.zeroc.IceInternal.OutgoingAsync<Void> f = new com.zeroc.IceInternal.OutgoingAsync<>(this, "recibirNotificacionEscasezSuministro", null, sync, null);
        f.invoke(false, context, null, ostr -> {
                     ostr.writeProxy(iceP_serverProxy);
                     ostr.writeString(iceP_idSumin);
                     ostr.writeInt(iceP_idMaq);
                     ostr.writeString(iceP_idAlarma);
                 }, null);
        return f;
    }

    default void recibirNotificacionAbastesimiento(ServicioAbastecimientoPrx serverProxy, int idMaq, String idInsumo, int cantidad, String idAlarma)
    {
        recibirNotificacionAbastesimiento(serverProxy, idMaq, idInsumo, cantidad, idAlarma, com.zeroc.Ice.ObjectPrx.noExplicitContext);
    }

    default void recibirNotificacionAbastesimiento(ServicioAbastecimientoPrx serverProxy, int idMaq, String idInsumo, int cantidad, String idAlarma, java.util.Map<String, String> context)
    {
        _iceI_recibirNotificacionAbastesimientoAsync(serverProxy, idMaq, idInsumo, cantidad, idAlarma, context, true).waitForResponse();
    }

    default java.util.concurrent.CompletableFuture<Void> recibirNotificacionAbastesimientoAsync(ServicioAbastecimientoPrx serverProxy, int idMaq, String idInsumo, int cantidad, String idAlarma)
    {
        return _iceI_recibirNotificacionAbastesimientoAsync(serverProxy, idMaq, idInsumo, cantidad, idAlarma, com.zeroc.Ice.ObjectPrx.noExplicitContext, false);
    }

    default java.util.concurrent.CompletableFuture<Void> recibirNotificacionAbastesimientoAsync(ServicioAbastecimientoPrx serverProxy, int idMaq, String idInsumo, int cantidad, String idAlarma, java.util.Map<String, String> context)
    {
        return _iceI_recibirNotificacionAbastesimientoAsync(serverProxy, idMaq, idInsumo, cantidad, idAlarma, context, false);
    }

    /**
     * @hidden
     * @param iceP_serverProxy -
     * @param iceP_idMaq -
     * @param iceP_idInsumo -
     * @param iceP_cantidad -
     * @param iceP_idAlarma -
     * @param context -
     * @param sync -
     * @return -
     **/
    default com.zeroc.IceInternal.OutgoingAsync<Void> _iceI_recibirNotificacionAbastesimientoAsync(ServicioAbastecimientoPrx iceP_serverProxy, int iceP_idMaq, String iceP_idInsumo, int iceP_cantidad, String iceP_idAlarma, java.util.Map<String, String> context, boolean sync)
    {
        com.zeroc.IceInternal.OutgoingAsync<Void> f = new com.zeroc.IceInternal.OutgoingAsync<>(this, "recibirNotificacionAbastesimiento", null, sync, null);
        f.invoke(false, context, null, ostr -> {
                     ostr.writeProxy(iceP_serverProxy);
                     ostr.writeInt(iceP_idMaq);
                     ostr.writeString(iceP_idInsumo);
                     ostr.writeInt(iceP_cantidad);
                     ostr.writeString(iceP_idAlarma);
                 }, null);
        return f;
    }

    default void recibirNotificacionMalFuncionamiento(ServicioAbastecimientoPrx serverProxy, int idMaq, String descri, String idAlarma)
    {
        recibirNotificacionMalFuncionamiento(serverProxy, idMaq, descri, idAlarma, com.zeroc.Ice.ObjectPrx.noExplicitContext);
    }

    default void recibirNotificacionMalFuncionamiento(ServicioAbastecimientoPrx serverProxy, int idMaq, String descri, String idAlarma, java.util.Map<String, String> context)
    {
        _iceI_recibirNotificacionMalFuncionamientoAsync(serverProxy, idMaq, descri, idAlarma, context, true).waitForResponse();
    }

    default java.util.concurrent.CompletableFuture<Void> recibirNotificacionMalFuncionamientoAsync(ServicioAbastecimientoPrx serverProxy, int idMaq, String descri, String idAlarma)
    {
        return _iceI_recibirNotificacionMalFuncionamientoAsync(serverProxy, idMaq, descri, idAlarma, com.zeroc.Ice.ObjectPrx.noExplicitContext, false);
    }

    default java.util.concurrent.CompletableFuture<Void> recibirNotificacionMalFuncionamientoAsync(ServicioAbastecimientoPrx serverProxy, int idMaq, String descri, String idAlarma, java.util.Map<String, String> context)
    {
        return _iceI_recibirNotificacionMalFuncionamientoAsync(serverProxy, idMaq, descri, idAlarma, context, false);
    }

    /**
     * @hidden
     * @param iceP_serverProxy -
     * @param iceP_idMaq -
     * @param iceP_descri -
     * @param iceP_idAlarma -
     * @param context -
     * @param sync -
     * @return -
     **/
    default com.zeroc.IceInternal.OutgoingAsync<Void> _iceI_recibirNotificacionMalFuncionamientoAsync(ServicioAbastecimientoPrx iceP_serverProxy, int iceP_idMaq, String iceP_descri, String iceP_idAlarma, java.util.Map<String, String> context, boolean sync)
    {
        com.zeroc.IceInternal.OutgoingAsync<Void> f = new com.zeroc.IceInternal.OutgoingAsync<>(this, "recibirNotificacionMalFuncionamiento", null, sync, null);
        f.invoke(false, context, null, ostr -> {
                     ostr.writeProxy(iceP_serverProxy);
                     ostr.writeInt(iceP_idMaq);
                     ostr.writeString(iceP_descri);
                     ostr.writeString(iceP_idAlarma);
                 }, null);
        return f;
    }

    /**
     * Contacts the remote server to verify that the object implements this type.
     * Raises a local exception if a communication error occurs.
     * @param obj The untyped proxy.
     * @return A proxy for this type, or null if the object does not support this type.
     **/
    static AlarmaServicePrx checkedCast(com.zeroc.Ice.ObjectPrx obj)
    {
        return com.zeroc.Ice.ObjectPrx._checkedCast(obj, ice_staticId(), AlarmaServicePrx.class, _AlarmaServicePrxI.class);
    }

    /**
     * Contacts the remote server to verify that the object implements this type.
     * Raises a local exception if a communication error occurs.
     * @param obj The untyped proxy.
     * @param context The Context map to send with the invocation.
     * @return A proxy for this type, or null if the object does not support this type.
     **/
    static AlarmaServicePrx checkedCast(com.zeroc.Ice.ObjectPrx obj, java.util.Map<String, String> context)
    {
        return com.zeroc.Ice.ObjectPrx._checkedCast(obj, context, ice_staticId(), AlarmaServicePrx.class, _AlarmaServicePrxI.class);
    }

    /**
     * Contacts the remote server to verify that a facet of the object implements this type.
     * Raises a local exception if a communication error occurs.
     * @param obj The untyped proxy.
     * @param facet The name of the desired facet.
     * @return A proxy for this type, or null if the object does not support this type.
     **/
    static AlarmaServicePrx checkedCast(com.zeroc.Ice.ObjectPrx obj, String facet)
    {
        return com.zeroc.Ice.ObjectPrx._checkedCast(obj, facet, ice_staticId(), AlarmaServicePrx.class, _AlarmaServicePrxI.class);
    }

    /**
     * Contacts the remote server to verify that a facet of the object implements this type.
     * Raises a local exception if a communication error occurs.
     * @param obj The untyped proxy.
     * @param facet The name of the desired facet.
     * @param context The Context map to send with the invocation.
     * @return A proxy for this type, or null if the object does not support this type.
     **/
    static AlarmaServicePrx checkedCast(com.zeroc.Ice.ObjectPrx obj, String facet, java.util.Map<String, String> context)
    {
        return com.zeroc.Ice.ObjectPrx._checkedCast(obj, facet, context, ice_staticId(), AlarmaServicePrx.class, _AlarmaServicePrxI.class);
    }

    /**
     * Downcasts the given proxy to this type without contacting the remote server.
     * @param obj The untyped proxy.
     * @return A proxy for this type.
     **/
    static AlarmaServicePrx uncheckedCast(com.zeroc.Ice.ObjectPrx obj)
    {
        return com.zeroc.Ice.ObjectPrx._uncheckedCast(obj, AlarmaServicePrx.class, _AlarmaServicePrxI.class);
    }

    /**
     * Downcasts the given proxy to this type without contacting the remote server.
     * @param obj The untyped proxy.
     * @param facet The name of the desired facet.
     * @return A proxy for this type.
     **/
    static AlarmaServicePrx uncheckedCast(com.zeroc.Ice.ObjectPrx obj, String facet)
    {
        return com.zeroc.Ice.ObjectPrx._uncheckedCast(obj, facet, AlarmaServicePrx.class, _AlarmaServicePrxI.class);
    }

    /**
     * Returns a proxy that is identical to this proxy, except for the per-proxy context.
     * @param newContext The context for the new proxy.
     * @return A proxy with the specified per-proxy context.
     **/
    @Override
    default AlarmaServicePrx ice_context(java.util.Map<String, String> newContext)
    {
        return (AlarmaServicePrx)_ice_context(newContext);
    }

    /**
     * Returns a proxy that is identical to this proxy, except for the adapter ID.
     * @param newAdapterId The adapter ID for the new proxy.
     * @return A proxy with the specified adapter ID.
     **/
    @Override
    default AlarmaServicePrx ice_adapterId(String newAdapterId)
    {
        return (AlarmaServicePrx)_ice_adapterId(newAdapterId);
    }

    /**
     * Returns a proxy that is identical to this proxy, except for the endpoints.
     * @param newEndpoints The endpoints for the new proxy.
     * @return A proxy with the specified endpoints.
     **/
    @Override
    default AlarmaServicePrx ice_endpoints(com.zeroc.Ice.Endpoint[] newEndpoints)
    {
        return (AlarmaServicePrx)_ice_endpoints(newEndpoints);
    }

    /**
     * Returns a proxy that is identical to this proxy, except for the locator cache timeout.
     * @param newTimeout The new locator cache timeout (in seconds).
     * @return A proxy with the specified locator cache timeout.
     **/
    @Override
    default AlarmaServicePrx ice_locatorCacheTimeout(int newTimeout)
    {
        return (AlarmaServicePrx)_ice_locatorCacheTimeout(newTimeout);
    }

    /**
     * Returns a proxy that is identical to this proxy, except for the invocation timeout.
     * @param newTimeout The new invocation timeout (in seconds).
     * @return A proxy with the specified invocation timeout.
     **/
    @Override
    default AlarmaServicePrx ice_invocationTimeout(int newTimeout)
    {
        return (AlarmaServicePrx)_ice_invocationTimeout(newTimeout);
    }

    /**
     * Returns a proxy that is identical to this proxy, except for connection caching.
     * @param newCache <code>true</code> if the new proxy should cache connections; <code>false</code> otherwise.
     * @return A proxy with the specified caching policy.
     **/
    @Override
    default AlarmaServicePrx ice_connectionCached(boolean newCache)
    {
        return (AlarmaServicePrx)_ice_connectionCached(newCache);
    }

    /**
     * Returns a proxy that is identical to this proxy, except for the endpoint selection policy.
     * @param newType The new endpoint selection policy.
     * @return A proxy with the specified endpoint selection policy.
     **/
    @Override
    default AlarmaServicePrx ice_endpointSelection(com.zeroc.Ice.EndpointSelectionType newType)
    {
        return (AlarmaServicePrx)_ice_endpointSelection(newType);
    }

    /**
     * Returns a proxy that is identical to this proxy, except for how it selects endpoints.
     * @param b If <code>b</code> is <code>true</code>, only endpoints that use a secure transport are
     * used by the new proxy. If <code>b</code> is false, the returned proxy uses both secure and
     * insecure endpoints.
     * @return A proxy with the specified selection policy.
     **/
    @Override
    default AlarmaServicePrx ice_secure(boolean b)
    {
        return (AlarmaServicePrx)_ice_secure(b);
    }

    /**
     * Returns a proxy that is identical to this proxy, except for the encoding used to marshal parameters.
     * @param e The encoding version to use to marshal request parameters.
     * @return A proxy with the specified encoding version.
     **/
    @Override
    default AlarmaServicePrx ice_encodingVersion(com.zeroc.Ice.EncodingVersion e)
    {
        return (AlarmaServicePrx)_ice_encodingVersion(e);
    }

    /**
     * Returns a proxy that is identical to this proxy, except for its endpoint selection policy.
     * @param b If <code>b</code> is <code>true</code>, the new proxy will use secure endpoints for invocations
     * and only use insecure endpoints if an invocation cannot be made via secure endpoints. If <code>b</code> is
     * <code>false</code>, the proxy prefers insecure endpoints to secure ones.
     * @return A proxy with the specified selection policy.
     **/
    @Override
    default AlarmaServicePrx ice_preferSecure(boolean b)
    {
        return (AlarmaServicePrx)_ice_preferSecure(b);
    }

    /**
     * Returns a proxy that is identical to this proxy, except for the router.
     * @param router The router for the new proxy.
     * @return A proxy with the specified router.
     **/
    @Override
    default AlarmaServicePrx ice_router(com.zeroc.Ice.RouterPrx router)
    {
        return (AlarmaServicePrx)_ice_router(router);
    }

    /**
     * Returns a proxy that is identical to this proxy, except for the locator.
     * @param locator The locator for the new proxy.
     * @return A proxy with the specified locator.
     **/
    @Override
    default AlarmaServicePrx ice_locator(com.zeroc.Ice.LocatorPrx locator)
    {
        return (AlarmaServicePrx)_ice_locator(locator);
    }

    /**
     * Returns a proxy that is identical to this proxy, except for collocation optimization.
     * @param b <code>true</code> if the new proxy enables collocation optimization; <code>false</code> otherwise.
     * @return A proxy with the specified collocation optimization.
     **/
    @Override
    default AlarmaServicePrx ice_collocationOptimized(boolean b)
    {
        return (AlarmaServicePrx)_ice_collocationOptimized(b);
    }

    /**
     * Returns a proxy that is identical to this proxy, but uses twoway invocations.
     * @return A proxy that uses twoway invocations.
     **/
    @Override
    default AlarmaServicePrx ice_twoway()
    {
        return (AlarmaServicePrx)_ice_twoway();
    }

    /**
     * Returns a proxy that is identical to this proxy, but uses oneway invocations.
     * @return A proxy that uses oneway invocations.
     **/
    @Override
    default AlarmaServicePrx ice_oneway()
    {
        return (AlarmaServicePrx)_ice_oneway();
    }

    /**
     * Returns a proxy that is identical to this proxy, but uses batch oneway invocations.
     * @return A proxy that uses batch oneway invocations.
     **/
    @Override
    default AlarmaServicePrx ice_batchOneway()
    {
        return (AlarmaServicePrx)_ice_batchOneway();
    }

    /**
     * Returns a proxy that is identical to this proxy, but uses datagram invocations.
     * @return A proxy that uses datagram invocations.
     **/
    @Override
    default AlarmaServicePrx ice_datagram()
    {
        return (AlarmaServicePrx)_ice_datagram();
    }

    /**
     * Returns a proxy that is identical to this proxy, but uses batch datagram invocations.
     * @return A proxy that uses batch datagram invocations.
     **/
    @Override
    default AlarmaServicePrx ice_batchDatagram()
    {
        return (AlarmaServicePrx)_ice_batchDatagram();
    }

    /**
     * Returns a proxy that is identical to this proxy, except for compression.
     * @param co <code>true</code> enables compression for the new proxy; <code>false</code> disables compression.
     * @return A proxy with the specified compression setting.
     **/
    @Override
    default AlarmaServicePrx ice_compress(boolean co)
    {
        return (AlarmaServicePrx)_ice_compress(co);
    }

    /**
     * Returns a proxy that is identical to this proxy, except for its connection timeout setting.
     * @param t The connection timeout for the proxy in milliseconds.
     * @return A proxy with the specified timeout.
     **/
    @Override
    default AlarmaServicePrx ice_timeout(int t)
    {
        return (AlarmaServicePrx)_ice_timeout(t);
    }

    /**
     * Returns a proxy that is identical to this proxy, except for its connection ID.
     * @param connectionId The connection ID for the new proxy. An empty string removes the connection ID.
     * @return A proxy with the specified connection ID.
     **/
    @Override
    default AlarmaServicePrx ice_connectionId(String connectionId)
    {
        return (AlarmaServicePrx)_ice_connectionId(connectionId);
    }

    /**
     * Returns a proxy that is identical to this proxy, except it's a fixed proxy bound
     * the given connection.@param connection The fixed proxy connection.
     * @return A fixed proxy bound to the given connection.
     **/
    @Override
    default AlarmaServicePrx ice_fixed(com.zeroc.Ice.Connection connection)
    {
        return (AlarmaServicePrx)_ice_fixed(connection);
    }

    static String ice_staticId()
    {
        return "::servicios::AlarmaService";
    }
}
