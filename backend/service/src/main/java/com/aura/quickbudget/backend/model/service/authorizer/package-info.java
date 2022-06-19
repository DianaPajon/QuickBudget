/**
 * This package contain the authorizers for the services provided on the parent package.
 * 
 * An authorizer consiste on a set of methods, wich parallel the methods on a service,
 * but they contain an extra argument, the username. All of these methods have a 
 * specific return type, a "token" type that can only be produced by this type.
 * 
 * Right now this package needs a full implementation. In the future they will
 * only require a repository to be implemented.
 */

package com.aura.quickbudget.backend.model.service.authorizer;
