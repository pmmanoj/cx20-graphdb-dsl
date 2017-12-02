package com.evds.graphdb

/**
 * TEST a connection to your Graph-DB
 *
 *   Ref. URL:
 *   http://docs.datastax.com/en/developer/java-driver-dse/1.4/manual/tinkerpop/
 *   http://docs.datastax.com/en/developer/java-driver-dse/1.4/manual/graph/
 *
 */

// DSE
import com.datastax.driver.dse.DseSession
import com.datastax.driver.dse.DseCluster

// Graph
import com.datastax.driver.dse.graph.GraphOptions
import com.datastax.driver.dse.graph.GraphNode
import com.datastax.driver.dse.graph.GraphResultSet
import com.datastax.driver.dse.graph.GraphStatement
import com.datastax.driver.dse.graph.SimpleGraphStatement

// Gremlin
import org.apache.tinkerpop.gremlin.process.traversal.dsl.graph.GraphTraversalSource

// Establish Connection
DseCluster dseCluster = DseCluster.builder()
        .addContactPoint("192.168.99.56")
        .withGraphOptions(  new GraphOptions().setGraphName("LinkGraph01") )
        .build()

DseSession dseSession = dseCluster.connect()

// Establish TRAVERSAL 'Gremlin' TinkerPOP
// GraphTraversalSource g = DseGraph.traversal(dseSession)

// Query Execute: get all the Vertices
GraphStatement s1 = new SimpleGraphStatement("g.V()")
GraphResultSet rs = dseSession.executeGraph(s1)

for (GraphNode n: rs) {
    println(n)
}

println "/n Do you see all the Vertices ... then GraphConnect TEST is OK . . . "



