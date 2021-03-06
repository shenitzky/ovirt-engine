/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
*/

package org.ovirt.engine.api.v3.servers;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.ovirt.engine.api.resource.DiskProfilesResource;
import org.ovirt.engine.api.v3.V3Server;
import org.ovirt.engine.api.v3.types.V3DiskProfile;
import org.ovirt.engine.api.v3.types.V3DiskProfiles;

@Produces({"application/xml", "application/json"})
public class V3DiskProfilesServer extends V3Server<DiskProfilesResource> {
    public V3DiskProfilesServer(DiskProfilesResource delegate) {
        super(delegate);
    }

    @POST
    @Consumes({"application/xml", "application/json"})
    public Response add(V3DiskProfile profile) {
        return adaptAdd(getDelegate()::add, profile);
    }

    @GET
    public V3DiskProfiles list() {
        return adaptList(getDelegate()::list);
    }

    @Path("{id}")
    public V3DiskProfileServer getDiskProfileResource(@PathParam("id") String id) {
        return new V3DiskProfileServer(getDelegate().getDiskProfileResource(id));
    }
}
