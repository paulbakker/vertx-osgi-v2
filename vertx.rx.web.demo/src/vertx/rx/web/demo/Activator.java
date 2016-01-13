package vertx.rx.web.demo;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

import io.vertx.rxjava.core.http.HttpServer;
import io.vertx.rxjava.core.Vertx;
import io.vertx.rxjava.ext.web.Route;
import io.vertx.rxjava.ext.web.Router;
import io.vertx.rxjava.ext.web.handler.StaticHandler;


public class Activator implements BundleActivator{

	@Override
	public void start(BundleContext context) throws Exception {
		
		Vertx vertx = Vertx.vertx();
		Router router = Router.router(vertx);
		
		Route route = router.route("/static/*");
		route.handler(StaticHandler.create());
		
		HttpServer server = vertx.createHttpServer();
		server.requestHandler(router::accept).listen(8080);	
	}

	@Override
	public void stop(BundleContext context) throws Exception {
		// TODO Auto-generated method stub
		
	}

}
