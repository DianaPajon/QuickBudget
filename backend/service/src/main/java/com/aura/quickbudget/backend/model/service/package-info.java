/*
 * This package will contain all the code actually implementing the services
 * provided by the backend. 
 * 
 * The types on this package either ond on "Service" or
 * "Authorizer", the "Service" types are actual services provided by the backend.
 * while the "Authorizer" types are interfaces (as of today) that must comply
 * some concrete authorizer to obtain the token that grants ahtorization to use
 * the service methods.
 * 
 * The main idea of these types is that they only need to have a repository and an
 * andpoint "plugged-in" to work, and no more coding is needeed.
 * 
 * As of today, concrete authorizers are also needed, they will be implememented
 * as abstract classes depending on a repository at a later moment.
 * 
 *
 */
package com.aura.quickbudget.backend.model.service;