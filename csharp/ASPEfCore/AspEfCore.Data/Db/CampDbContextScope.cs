﻿using EntityFramework.DbContextScope.Interfaces;
using System;
using System.Collections.Generic;
using System.Text;

namespace AspEfCore.Data.Db
{
    public interface ICampDbContextScope : IDisposable
    {
        int SaveChanges();
    }

    public class CampDbContextScope : ICampDbContextScope
    {
        private readonly IDbContextScope _dbContextScope;
        private readonly IAmbientDbContextLocator _dbContextLocator;
        private bool _disposed;

        public CampDbContextScope(
            IDbContextScope dbContextScope,
            IAmbientDbContextLocator dbContextLocator)
        {
            _dbContextScope = dbContextScope;
            _dbContextLocator = dbContextLocator;
        }

        public int SaveChanges()
        {
            var i = _dbContextScope.SaveChanges();

            return i;
        }

        public void Dispose()
        {
            Dispose(true);
            GC.SuppressFinalize(this);
        }

        protected virtual void Dispose(bool disposing)
        {
            if (_disposed)
                return;

            if (disposing)
                _dbContextScope.Dispose();

            _disposed = true;
        }
    }
}
