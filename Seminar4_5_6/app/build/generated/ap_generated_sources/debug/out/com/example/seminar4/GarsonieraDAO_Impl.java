package com.example.seminar4;

import android.database.Cursor;
import androidx.annotation.NonNull;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.lang.Class;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@SuppressWarnings({"unchecked", "deprecation"})
public final class GarsonieraDAO_Impl implements GarsonieraDAO {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<Garsoniera> __insertionAdapterOfGarsoniera;

  private final EntityDeletionOrUpdateAdapter<Garsoniera> __deletionAdapterOfGarsoniera;

  private final EntityDeletionOrUpdateAdapter<Garsoniera> __updateAdapterOfGarsoniera;

  public GarsonieraDAO_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfGarsoniera = new EntityInsertionAdapter<Garsoniera>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR ABORT INTO `Garsoniera` (`id`,`oras`,`strada`,`nrEtaj`,`nrApartament`,`esteOcupata`) VALUES (nullif(?, 0),?,?,?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          final Garsoniera entity) {
        statement.bindLong(1, entity.id);
        if (entity.getOras() == null) {
          statement.bindNull(2);
        } else {
          statement.bindString(2, entity.getOras());
        }
        if (entity.getStrada() == null) {
          statement.bindNull(3);
        } else {
          statement.bindString(3, entity.getStrada());
        }
        statement.bindLong(4, entity.getNrEtaj());
        statement.bindLong(5, entity.getNrApartament());
        final int _tmp = entity.getEsteOcupata() ? 1 : 0;
        statement.bindLong(6, _tmp);
      }
    };
    this.__deletionAdapterOfGarsoniera = new EntityDeletionOrUpdateAdapter<Garsoniera>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "DELETE FROM `Garsoniera` WHERE `id` = ?";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          final Garsoniera entity) {
        statement.bindLong(1, entity.id);
      }
    };
    this.__updateAdapterOfGarsoniera = new EntityDeletionOrUpdateAdapter<Garsoniera>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "UPDATE OR ABORT `Garsoniera` SET `id` = ?,`oras` = ?,`strada` = ?,`nrEtaj` = ?,`nrApartament` = ?,`esteOcupata` = ? WHERE `id` = ?";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          final Garsoniera entity) {
        statement.bindLong(1, entity.id);
        if (entity.getOras() == null) {
          statement.bindNull(2);
        } else {
          statement.bindString(2, entity.getOras());
        }
        if (entity.getStrada() == null) {
          statement.bindNull(3);
        } else {
          statement.bindString(3, entity.getStrada());
        }
        statement.bindLong(4, entity.getNrEtaj());
        statement.bindLong(5, entity.getNrApartament());
        final int _tmp = entity.getEsteOcupata() ? 1 : 0;
        statement.bindLong(6, _tmp);
        statement.bindLong(7, entity.id);
      }
    };
  }

  @Override
  public void insertGarsoniera(final Garsoniera garsoniera) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfGarsoniera.insert(garsoniera);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void delete(final Garsoniera garsoniera) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __deletionAdapterOfGarsoniera.handle(garsoniera);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void update(final Garsoniera garsoniera) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __updateAdapterOfGarsoniera.handle(garsoniera);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public List<Garsoniera> getAllGarsoniere() {
    final String _sql = "SELECT * FROM Garsoniera";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfOras = CursorUtil.getColumnIndexOrThrow(_cursor, "oras");
      final int _cursorIndexOfStrada = CursorUtil.getColumnIndexOrThrow(_cursor, "strada");
      final int _cursorIndexOfNrEtaj = CursorUtil.getColumnIndexOrThrow(_cursor, "nrEtaj");
      final int _cursorIndexOfNrApartament = CursorUtil.getColumnIndexOrThrow(_cursor, "nrApartament");
      final int _cursorIndexOfEsteOcupata = CursorUtil.getColumnIndexOrThrow(_cursor, "esteOcupata");
      final List<Garsoniera> _result = new ArrayList<Garsoniera>(_cursor.getCount());
      while (_cursor.moveToNext()) {
        final Garsoniera _item;
        _item = new Garsoniera();
        _item.id = _cursor.getInt(_cursorIndexOfId);
        final String _tmpOras;
        if (_cursor.isNull(_cursorIndexOfOras)) {
          _tmpOras = null;
        } else {
          _tmpOras = _cursor.getString(_cursorIndexOfOras);
        }
        _item.setOras(_tmpOras);
        final String _tmpStrada;
        if (_cursor.isNull(_cursorIndexOfStrada)) {
          _tmpStrada = null;
        } else {
          _tmpStrada = _cursor.getString(_cursorIndexOfStrada);
        }
        _item.setStrada(_tmpStrada);
        final int _tmpNrEtaj;
        _tmpNrEtaj = _cursor.getInt(_cursorIndexOfNrEtaj);
        _item.setNrEtaj(_tmpNrEtaj);
        final int _tmpNrApartament;
        _tmpNrApartament = _cursor.getInt(_cursorIndexOfNrApartament);
        _item.setNrApartament(_tmpNrApartament);
        final boolean _tmpEsteOcupata;
        final int _tmp;
        _tmp = _cursor.getInt(_cursorIndexOfEsteOcupata);
        _tmpEsteOcupata = _tmp != 0;
        _item.setEsteOcupata(_tmpEsteOcupata);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @NonNull
  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
