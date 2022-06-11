/**
 * This package aims to provide the tools for obtaining and persisting the types in the 
 * com.quickbudget.backend.model.api package.
 * 
 * Its goal is to give the business code a set of methods to persist the data. So the main
 * idea behind its is that the methods are actually "grouped" according to the "business unit"
 * where they are actually used, and by business unit I'm refering to the things the system
 * is doing at a given moment and must be persisted.
 * 
 * @see com.quickbudget.backend.model.api
 */
package com.quickbudget.backend.model.api.repository;